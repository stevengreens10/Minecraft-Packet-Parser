package minecraftpacketparser.parser;

import minecraftpacketparser.parser.datatype.*;
import minecraftpacketparser.parser.datatype.particle.BlockParticle;
import minecraftpacketparser.parser.datatype.particle.DustParticle;
import minecraftpacketparser.parser.datatype.particle.ItemParticle;
import minecraftpacketparser.parser.datatype.particle.Particle;
import minecraftpacketparser.proxy.Serializer;
import net.querz.nbt.io.NBTDeserializer;
import net.querz.nbt.io.NamedTag;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.reflections.Reflections;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.*;

public class Parser {

    // state -> direction -> packet ID -> parser
    private static final Map<State, Map<Direction, Map<String, AbstractPacketParser>>> parsers = new HashMap<>();
    public State state = State.HANDSHAKE;

    private PrintStream outputStream;

    public Parser(PrintStream output) {
        outputStream = output;
    }

    public static void initialize() {
        // Setup map structure
        parsers.put(State.HANDSHAKE, new HashMap<>());
        parsers.put(State.STATUS, new HashMap<>());
        parsers.put(State.LOGIN, new HashMap<>());
        parsers.put(State.PLAY, new HashMap<>());
        parsers.get(State.HANDSHAKE).put(Direction.CLIENTBOUND, new HashMap<>());
        parsers.get(State.HANDSHAKE).put(Direction.SERVERBOUND, new HashMap<>());
        parsers.get(State.STATUS).put(Direction.CLIENTBOUND, new HashMap<>());
        parsers.get(State.STATUS).put(Direction.SERVERBOUND, new HashMap<>());
        parsers.get(State.LOGIN).put(Direction.CLIENTBOUND, new HashMap<>());
        parsers.get(State.LOGIN).put(Direction.SERVERBOUND, new HashMap<>());
        parsers.get(State.PLAY).put(Direction.CLIENTBOUND, new HashMap<>());
        parsers.get(State.PLAY).put(Direction.SERVERBOUND, new HashMap<>());

        Reflections reflections = new Reflections("minecraftpacketparser.parser");
        Set<Class<? extends AbstractPacketParser>> parsers = reflections.getSubTypesOf(AbstractPacketParser.class);

        for (Class<? extends AbstractPacketParser> parser : parsers) {
            try {
                AbstractPacketParser abstractPacketParser = parser.newInstance();
                State state = abstractPacketParser.state;
                Direction dir = abstractPacketParser.direction;
                String id = abstractPacketParser.id;

                if (state != null && dir != null && id != null) {
                    addParser(state, dir, id, abstractPacketParser);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void addParser(State state, Direction dir, String id, AbstractPacketParser parser) {
        System.out.printf("Adding parser with state %s, direction %s, id %s, name %s\n",
                state.name(), dir.name(), id, parser.getClass().getSimpleName());
        parsers.get(state).get(dir).put(id, parser);
    }

    public ByteArrayOutputStream parseSocketPacket(InputStream input, Direction direction) throws IOException {
        int length = Parser.parseVarInt(input);
        byte[] packetBytes = new byte[length];
        DataInputStream dis = new DataInputStream(input);
        dis.readFully(packetBytes);

        ByteArrayInputStream packetStream = new ByteArrayInputStream(packetBytes);

        ParseResult result = handlePacket(packetStream, direction);

        ByteArrayOutputStream output;

        if(result == null || result.output == null) {
            output = new ByteArrayOutputStream();
            output.write(packetBytes);
        } else {
            output = result.output;
        }

        // Compute message len as varint and write to beginning of output
        if(output.size() > 0) {
            ByteArrayOutputStream outputWithLen = new ByteArrayOutputStream();
            Serializer.writeVarInt(output.size(), outputWithLen);
            output.writeTo(outputWithLen);
            output = outputWithLen;
        }

        return output;
    }

    public void parsePcapPackets(InputStream input, ArrayList<Direction> messageDirections) throws IOException {
        int index = 0;
        while(input.available() > 0) {
            int length = Parser.parseVarInt(input);
            byte[] packetBytes = new byte[length];
            int bytesRead = input.read(packetBytes, 0, packetBytes.length);

            if(bytesRead <= 0) {
                throw new RuntimeException("Unable to read from input stream");
            }

            ByteArrayInputStream packetStream = new ByteArrayInputStream(packetBytes);

            handlePacket(packetStream, messageDirections.get(index++));
        }
    }

    private ParseResult handlePacket(ByteArrayInputStream packetData, Direction direction) throws IOException {
        int length = packetData.available();

        String packetID = Parser.intToHexStr(Parser.parseVarInt(packetData));

        outputStream.printf("\nPacket ID: %-6s | Length: %-5d | State: %-10s | Direction: %s\n",
                packetID, length, state.name(), direction.name());

        AbstractPacketParser parser = parsers.get(state).get(direction).get(packetID);
        if(parser != null) {
            try {
                ParseResult result = parser.parse(this, packetData);

                if (result != null) {
                    if (result.resultState != null) {
                        state = result.resultState;
                    }
                    writeOutput(outputStream, result);
                    return result;
                }
            } catch (Exception e) {
                e.printStackTrace();
                outputStream.printf(e.getMessage());
            }

        } else {
            outputStream.println("\tNo parser!");
            throw new RuntimeException(String.format("No parser for packet ID %s in state %s with %s direction", packetID, state.name(), direction.name()));
        }

        return null;
    }

    private synchronized void writeOutput(PrintStream output, ParseResult parseResult) {
        synchronized (this) {
            output.printf("\tPacket Type: %s\n", parseResult.packetType);
            if(!parseResult.printFullPacket) return;
            for(Map.Entry<String, Object> entry : parseResult.packetFields.entrySet() ) {
                String fieldName = entry.getKey();
                String fieldValue = entry.getValue().toString();
                String[] lines = fieldValue.split("\n");
                if (lines.length == 1) {
                    output.printf("\t%s: %s\n", fieldName, fieldValue);
                } else {
                    output.printf("\t%s:\n", fieldName);
                    for (String line : lines) {
                        output.printf("\t\t%s\n", line);
                    }
                }
            }
        }
    }

    public static String intToHexStr(int val) {
        return String.format("0x%02X", val);
    }

    public static UUID parseUUID(InputStream data) throws IOException {
        long mostSigBits = parseLong(data);
        long leastSigBits = parseLong(data);
        return new UUID(mostSigBits, leastSigBits);
    }

    public static Position parsePosition(InputStream data) throws IOException {
        long val = parseLong(data);

        long x = val >> 38;
        long z = (val << 26 >> 38);
        // Properly does sign extension. Simply doing & 0xFFF does not.
        long y = (val << 52 >> 52);

        return new Position((int) x, (int) y, (int) z);
    }

    public static NamedTag parseNBT(InputStream data) throws IOException {
        try {
            return new NBTDeserializer(false).fromStream(data);
        } catch (EOFException e) {
                return null;
        }
    }

    public static EntityMetadata parseEntityMetadata(InputStream data) throws IOException {
        EntityMetadata metadata = new EntityMetadata();

        int index = Parser.parseUnsignedByte(data);
        metadata.index = index;

        if(index != 0xFF) {
            int type = Parser.parseVarInt(data);
            metadata.type = EntityMetadata.Type.values()[type];

            switch(metadata.type) {
                case BYTE:
                    metadata.value = Parser.parseByte(data);
                    break;
                case VARINT:
                case OPTVARINT:
                case OPTBLOCKID:
                    metadata.value = Parser.parseVarInt(data);
                    break;
                case FLOAT:
                    metadata.value = Parser.parseFloat(data);
                    break;
                case STRING:
                    metadata.value = Parser.parseString(data);
                    break;
                case CHAT:
                    metadata.value = Parser.parseChat(data);
                    break;
                case OPTCHAT:
                    metadata.optionalPresent = Parser.parseBoolean(data);
                    if(metadata.optionalPresent)
                        metadata.value = Parser.parseChat(data);
                    break;
                case SLOT:
                    metadata.value = Parser.parseSlot(data);
                    break;
                case BOOLEAN:
                    metadata.value = Parser.parseBoolean(data);
                    break;
                case ROTATION:
                    metadata.value = new Rotation(Parser.parseFloat(data),
                            Parser.parseFloat(data), Parser.parseFloat(data));
                    break;
                case POSITION:
                    metadata.value = Parser.parsePosition(data);
                    break;
                case OPTPOSITION:
                    metadata.optionalPresent = Parser.parseBoolean(data);
                    if(metadata.optionalPresent)
                        metadata.value = Parser.parsePosition(data);
                    break;
                case DIRECTION:
                    metadata.value = DirectionDataType.values()[Parser.parseVarInt(data)];
                    break;
                case OPTUUID:
                    metadata.optionalPresent = Parser.parseBoolean(data);
                    if(metadata.optionalPresent)
                        metadata.value = Parser.parseUUID(data);
                    break;
                case NBT:
                    metadata.value = Parser.parseNBT(data);
                    break;
                case PARTICLE:
                    int particleID = Parser.parseVarInt(data);
                    Particle particle;

                    if(particleID == 3 || particleID == 23) {
                        particle = new BlockParticle(particleID, Parser.parseVarInt(data));
                    } else if(particleID == 14) {
                        particle = new DustParticle(particleID, Parser.parseFloat(data), Parser.parseFloat(data),
                                Parser.parseFloat(data), Parser.parseFloat(data));
                    } else if(particleID == 32) {
                        particle = new ItemParticle(particleID, Parser.parseSlot(data));
                    } else {
                        particle = new Particle(particleID);
                    }
                    metadata.value = particle;
                    break;
                case VILLAGERDATA:
                    metadata.value = new VillagerData(Parser.parseVarInt(data),
                            Parser.parseVarInt(data), Parser.parseVarInt(data));
                    break;
                case POSE:
                    metadata.value = Pose.values()[Parser.parseVarInt(data)];
                    break;
            }

        }

        return metadata;
    }

    public static Slot parseSlot(InputStream data) throws IOException {
        Slot slot = new Slot();
        slot.present = Parser.parseBoolean(data);
        if(slot.present) {
            slot.itemID = Parser.parseVarInt(data);
            slot.itemCount = Parser.parseUnsignedByte(data);
            slot.nbtData = Parser.parseNBT(data);
        }
        return slot;
    }

    public static Boolean parseBoolean(InputStream data) throws IOException {
        byte val = readByte(data);
        if(val == 1) {
            return true;
        } else if(val == 0) {
            return false;
        }
        throw new RuntimeException("Invalid boolean: " + intToHexStr(val));
    }

    public static Byte parseByte(InputStream data) throws IOException {
        return readByte(data);
    }

    public static Integer parseUnsignedByte(InputStream data) throws IOException {
        return readByte(data) & 0xFF;
    }

    public static Short parseShort(InputStream data) throws IOException {
        byte[] bytes = readBytes(data, 2);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getShort();
    }

    public static Integer parseUnsignedShort(InputStream data) throws IOException {
        byte[] bytes = readBytes(data, 2);
        return ((bytes[0] & 0xFF) << 8) | (bytes[1] & 0xFF);
    }

    public static Integer parseInt(InputStream data) throws IOException {
        byte[] bytes = readBytes(data, 4);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getInt();
    }

    public static Long parseLong(InputStream data) throws IOException {
        byte[] bytes = readBytes(data, 8);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getLong();
    }

    public static Float parseFloat(InputStream data) throws IOException {
        byte[] bytes = readBytes(data, 4);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getFloat();
    }

    public static Double parseDouble(InputStream data) throws IOException {
        byte[] bytes = readBytes(data, 8);
        return ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getDouble();
    }

    public static Integer parseAngle(InputStream data) throws IOException {
        // Angles are equivalent to unsigned bytes.
        // Represents steps of 1/256 of a full turn
        return parseUnsignedByte(data);
    }

    public static Integer parseVarInt(InputStream data) throws IOException {
        int numRead = 0;
        int result = 0;
        byte read;
        do {
            read = readByte(data);
            int value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 5) {
                throw new RuntimeException("VarInt is too big");
            }
        } while ((read & 0b10000000) != 0);

        return result;
    }

    public static Long parseVarLong(InputStream data) throws IOException {
        int numRead = 0;
        long result = 0;
        byte read;
        do {
            read = readByte(data);
            long value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 10) {
                throw new RuntimeException("VarLong is too big");
            }
        } while ((read & 0b10000000) != 0);

        return result;
    }

    public static String parseString(InputStream data) throws IOException {
        int length = Parser.parseVarInt(data);
        byte[] strBytes = readBytes(data, length);
        return new String(strBytes);
    }

    public static String parseChat(InputStream data) throws IOException {
        String chatMsg = parseString(data);
        if(!isJSONValid(chatMsg)) {
            throw new RuntimeException("Invalid JSON for chat data: " + chatMsg);
        }
        return chatMsg;
    }

    private static boolean isJSONValid(String str) {
        try {
            new JSONObject(str);
        } catch (JSONException ex) {
            try {
                new JSONArray(str);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    public static String parseIdentifier(InputStream data) throws IOException {
        String identifier = parseString(data);
        boolean valid = true;
        int numColons = 0;
        for(char c : identifier.toCharArray()) {
            if (c == ':') {
                numColons++;
            }
            if( (c != '-' && c < '0') || (c != ':' && c != '_' && c > '9' && c < 'a') || c > 'z') {
                valid = false;
                break;
            }
        }

        if(!valid || identifier.startsWith(":") || numColons > 1) {
            throw new RuntimeException("Identifier is not valid: " + identifier);
        }

        return identifier;
    }

    private static byte readByte(InputStream data) throws IOException {
        byte[] bytes = readBytes(data, 1);
        return bytes[0];
    }

    public static byte[] readBytes(InputStream data, int numBytes) throws IOException {
        byte[] bytes = new byte[numBytes];
        int numRead = data.read(bytes, 0, numBytes);
        if(numRead < numBytes) {
            throw new RuntimeException("Not enough data to parse data. Read " + numRead + " out of " + numBytes + " bytes.");
        }
        return bytes;
    }
}