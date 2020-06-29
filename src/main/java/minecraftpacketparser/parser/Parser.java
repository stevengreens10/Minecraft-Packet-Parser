package minecraftpacketparser.parser;

import minecraftpacketparser.parser.datatype.Position;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class Parser {

    // state -> direction -> packet ID -> parser
    private static Map<State, Map<Direction, Map<String, AbstractPacketParser>>> parsers = new HashMap<>();
    public static State state = State.PLAY;

    public static void initialize() {
        // Setup map structure
        parsers.put(State.HANDSHAKE, new HashMap<Direction, Map<String, AbstractPacketParser>>());
        parsers.put(State.STATUS, new HashMap<Direction, Map<String, AbstractPacketParser>>());
        parsers.put(State.LOGIN, new HashMap<Direction, Map<String, AbstractPacketParser>>());
        parsers.put(State.PLAY, new HashMap<Direction, Map<String, AbstractPacketParser>>());
        parsers.get(State.HANDSHAKE).put(Direction.CLIENTBOUND, new HashMap<String, AbstractPacketParser>());
        parsers.get(State.HANDSHAKE).put(Direction.SERVERBOUND, new HashMap<String, AbstractPacketParser>());
        parsers.get(State.STATUS).put(Direction.CLIENTBOUND, new HashMap<String, AbstractPacketParser>());
        parsers.get(State.STATUS).put(Direction.SERVERBOUND, new HashMap<String, AbstractPacketParser>());
        parsers.get(State.LOGIN).put(Direction.CLIENTBOUND, new HashMap<String, AbstractPacketParser>());
        parsers.get(State.LOGIN).put(Direction.SERVERBOUND, new HashMap<String, AbstractPacketParser>());
        parsers.get(State.PLAY).put(Direction.CLIENTBOUND, new HashMap<String, AbstractPacketParser>());
        parsers.get(State.PLAY).put(Direction.SERVERBOUND, new HashMap<String, AbstractPacketParser>());

        Reflections reflections = new Reflections("minecraftpacketparser.parser");
        Set<Class<? extends AbstractPacketParser>> parsers = reflections.getSubTypesOf(AbstractPacketParser.class);

        for(Class<? extends AbstractPacketParser> parser : parsers) {
            try {
                AbstractPacketParser abstractPacketParser = parser.newInstance();
                State state = abstractPacketParser.state;
                Direction dir = abstractPacketParser.direction;
                String id = abstractPacketParser.id;

                if(state != null && dir != null && id != null) {
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

    public static boolean handlePacket(InputStream packetData, Direction direction, PrintStream output) throws IOException {
        int length = Parser.parseVarInt(packetData);
        String packetID = Parser.intToHexStr(Parser.parseVarInt(packetData));

        output.printf("\nPacket ID: %-6s | Length: %-5d | State: %-10s | Direction: %s\n",
                packetID, length, state.name(), direction.name());

        AbstractPacketParser parser = parsers.get(state).get(direction).get(packetID);
        if(parser != null) {
            ParseResult result = parser.parse(packetData, output);

            if(result != null) {
                state = result.resultState;
                writeOutput(output, result);
            }

        } else {
            output.println("\tNo parser!");
            throw new RuntimeException(String.format("No parser for packet ID %s in state %s with %s direction", packetID, state.name(), direction.name()));
        }

        // Print packet for debugging
//        if(packetID.equalsIgnoreCase("0x03") && direction == Direction.SERVERBOUND) {
//            return true;
//        }

        return false;
    }

    private static void writeOutput(PrintStream output, ParseResult parseResult) {
        output.printf("\tPacket Type: %s\n", parseResult.parserName);
        for(Map.Entry<String, Object> entry : parseResult.packetFields.entrySet() ) {
            String fieldName = entry.getKey();
            Object fieldValue = entry.getValue();
            output.printf("\t%s: %s\n", fieldName, fieldValue);
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
        Long val =  parseLong(data);

        System.out.println("Position val: " + Long.toUnsignedString(val));

        long x = val >> 38;
        long z = (val << 26 >> 38);
        // Don't think this will do sign extension, but y shouldn't ever be negative
        long y = val & 0xFFF;

        return new Position((int) x, (int) y, (int) z);
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

    private static byte[] readBytes(InputStream data, int numBytes) throws IOException {
        byte[] bytes = new byte[numBytes];
        int numRead = data.read(bytes, 0, numBytes);
        if(numRead < numBytes) {
            throw new RuntimeException("Not enough data to parse data. Read" + numRead + " out of " + numBytes + " bytes.");
        }
        return bytes;
    }
}