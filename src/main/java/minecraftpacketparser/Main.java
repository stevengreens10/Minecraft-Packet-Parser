package minecraftpacketparser;

import io.pkts.PacketHandler;
import io.pkts.Pcap;
import io.pkts.buffer.Buffer;
import io.pkts.packet.Packet;
import io.pkts.packet.TCPPacket;
import io.pkts.protocol.Protocol;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.Parser;
import org.apache.commons.codec.binary.Hex;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        if(args.length < 2) {
            System.out.println("Need to specify pcap file and MC server port.");
            System.exit(-1);
        }

        final Pcap pcap = Pcap.openStream(args[0]);
        final int serverPort = Integer.parseInt(args[1]);

        final PrintStream output = new PrintStream(new File("result.txt"));

        Parser.initialize();

        pcap.loop(new PacketHandler() {
            public boolean nextPacket(Packet packet) throws IOException {
                if(packet.hasProtocol(Protocol.TCP)) {
                    TCPPacket tcpPacket = (TCPPacket) packet.getPacket(Protocol.TCP);
                    if(isServerPacket(tcpPacket, serverPort)) {
                        Buffer buffer = tcpPacket.getPayload();
                        if(buffer != null) {
                            InputStream data = new ByteArrayInputStream(buffer.getArray());
                            Direction dir = getDirection(tcpPacket, serverPort);

                            try {
                                boolean debug = Parser.handlePacket(data, dir, output);
                                if(debug) {
                                    System.out.println(packet.getPayload().getArray().length + " " + tcpPacket.getSourcePort() + " " + tcpPacket.getDestinationPort() + " " + Hex.encodeHexString(buffer.getArray()));
                                }
                            } catch (Exception e) {
                                System.out.println("Uh oh! " + e.getMessage());
                                System.out.println(packet.getPayload().getArray().length + " " + tcpPacket.getSourcePort() + " " + tcpPacket.getDestinationPort() + " " + Hex.encodeHexString(buffer.getArray()) + "\n");
                            }

                        }
                    }
                }

                return true;
            }
        });
        output.close();
    }

    private static Direction getDirection(TCPPacket tcpPacket, int serverPort) {
        return tcpPacket.getSourcePort() == serverPort ? Direction.CLIENTBOUND : Direction.SERVERBOUND;
    }

    private static boolean isServerPacket(TCPPacket tcpPacket, int serverPort) {
        return (tcpPacket.getSourcePort() == serverPort || tcpPacket.getDestinationPort() == serverPort)
                && tcpPacket.isPSH();
    }

}
