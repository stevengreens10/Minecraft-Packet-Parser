package minecraftpacketparser;

import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.Packet;
import io.pkts.packet.TCPPacket;
import io.pkts.protocol.Protocol;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.Parser;
import org.apache.commons.codec.binary.Hex;

import java.io.*;
import java.util.ArrayList;

public class PcapMain {

    public static void main(String[] args) throws IOException {
        if(args.length < 2) {
            System.out.println("Need to specify pcap file and MC server port.");
            System.exit(-1);
        }

        final Pcap pcap = Pcap.openStream(args[0]);
        final int serverPort = Integer.parseInt(args[1]);

        final PrintStream output = new PrintStream(new File("result.txt"));
        final OutputStream payloads = new FileOutputStream(new File("temp.txt"));

        final ArrayList<Direction> messageDirections = new ArrayList<>();
        final int[] bytesInMessageRead = {0};
        final int[] currentMessageLength = {0};

        pcap.loop(packet -> {
            boolean done = false;
            TCPPacket tcpPacket = shouldProcessPacket(packet, serverPort);
            if(tcpPacket != null) {
                Buffer buffer = tcpPacket.getPayload();
                if (buffer != null) {
                    byte[] bytes = buffer.getArray();
                    int bytesWritten = 0;

                    while(bytesWritten < bytes.length) {

                        if(bytesInMessageRead[0] == currentMessageLength[0]) {

                            if(messageDirections.size() == 175) {
                                done = true;
                                break;
                            }

                            bytesInMessageRead[0] = 0;
                            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes, bytesWritten, bytes.length-bytesWritten);
                            int numAvailableBefore = byteStream.available();
                            currentMessageLength[0] = Parser.parseVarInt(byteStream);
                            // Add length byte(s)
                            currentMessageLength[0] += (numAvailableBefore - byteStream.available());
                            messageDirections.add(getDirection(tcpPacket, serverPort));

//                            if(currentMessageLength[0] > bytes.length-bytesWritten) {
//                                currentMessageLength[0] += 3;
//                            }
                        }
                        int remainingInMessage = currentMessageLength[0] - bytesInMessageRead[0];

                        int numToWrite = bytes.length - bytesWritten;

                        if(remainingInMessage < numToWrite) {
                            numToWrite = remainingInMessage;
                        }

                        payloads.write(bytes, bytesWritten, numToWrite);
                        bytesInMessageRead[0] += numToWrite;
                        bytesWritten += numToWrite;
                    }


                }
            }
            return !done;
        });

        payloads.close();

        final InputStream input = new FileInputStream(new File("temp.txt"));
        Parser.initialize();
        Parser parser = new Parser(output);

        parser.parsePcapPackets(input, messageDirections);

        output.close();

        /*Parser.initialize();

        pcap.loop(packet -> {
            TCPPacket tcpPacket = shouldProcessPacket(packet, serverPort);
            if(tcpPacket != null) {
                Buffer buffer = tcpPacket.getPayload();
                if(buffer != null) {
                    byte[] bytes = buffer.getArray();
                    InputStream data = new ByteArrayInputStream(bytes);

                    int messageLength = Parser.parseVarInt(data);
                    Direction dir = getDirection(tcpPacket, serverPort);

                    if(data.available() < messageLength) {
                        messageLength += 32;
                        byte[] fullMessage = new byte[messageLength];
                        AtomicInteger index = new AtomicInteger(bytes.length);
                        System.arraycopy(bytes, 0, fullMessage, 0, index.get());

                        int finalMessageLength = messageLength;
                        pcap.loop(packet1 -> {
                            TCPPacket tcpPacket1 = shouldProcessPacket(packet1, serverPort);
                            if(tcpPacket1 != null) {
                                Buffer buffer1 = tcpPacket1.getPayload();
                                Direction dir1 = getDirection(tcpPacket1, serverPort);
                                if(buffer1 != null && dir1 == dir) {
                                    byte[] bytes1 = buffer1.getArray();
                                    int numToWrite = bytes1.length;
                                    if(index.get() + bytes1.length > finalMessageLength) {
                                        numToWrite = finalMessageLength - index.get();
                                    }
                                    System.arraycopy(bytes1, 0, fullMessage, index.get(), numToWrite);
                                    index.addAndGet(numToWrite);

                                    return index.get() < finalMessageLength;
                                }

                            }
                            return true;
                        });

                        data = new ByteArrayInputStream(fullMessage);
                    } else {
                        data = new ByteArrayInputStream(bytes);
                    }

                    try {
                        boolean debug = Parser.handlePacket(data, dir, output);
                        if(debug) {
                            System.out.println("---DEBUG PACKET---");
                            printPacket(packet, tcpPacket, buffer);
                        }
                    } catch (Exception e) {
                        System.out.println("Uh oh! " + e.getMessage());
                        printPacket(packet, tcpPacket, buffer);
                    }

                }
            }

            return true;
        });*/
        output.close();
    }

    private static void printPacket(Packet packet, TCPPacket tcpPacket, Buffer buffer) {
        System.out.println(packet.getPayload().getArray().length + " " + tcpPacket.getSourcePort() + " " + tcpPacket.getDestinationPort() + " " + Hex.encodeHexString(buffer.getArray()) + "\n");
    }

    private static Direction getDirection(TCPPacket tcpPacket, int serverPort) {
        return tcpPacket.getSourcePort() == serverPort ? Direction.CLIENTBOUND : Direction.SERVERBOUND;
    }

    private static TCPPacket shouldProcessPacket(Packet packet, int serverPort) throws IOException {
        if(packet.hasProtocol(Protocol.TCP)) {
            TCPPacket tcpPacket = (TCPPacket) packet.getPacket(Protocol.TCP);
            if (isServerPacket(tcpPacket, serverPort)) {
                return tcpPacket;
            }
        }
        return null;
    }

    private static boolean isServerPacket(TCPPacket tcpPacket, int serverPort) {
        return (tcpPacket.getSourcePort() == serverPort || tcpPacket.getDestinationPort() == serverPort)
                && tcpPacket.getPayload() != null && tcpPacket.getPayload().getArray().length > 0;
    }

}
