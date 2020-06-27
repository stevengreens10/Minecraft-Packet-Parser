package minecraftpacketparser.parser;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.reflections.Reflections;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

        output.println("Packet ID: " + packetID + " | Length: " + length);

        AbstractPacketParser parser = parsers.get(state).get(direction).get(packetID);
        if(parser != null) {
            parser.parse(packetData, output);
        } else {
            output.println("\tNot handled!");
            throw new RuntimeException(String.format("No parser for packet ID %s in state %s with %s direction", packetID, state.name(), direction.name()));
        }

        if(packetID.equalsIgnoreCase("0x03") && direction == Direction.SERVERBOUND) {
            return true;
        }

        return false;
    }

    public static String intToHexStr(int val) {
        return String.format("0x%02X", val);
    }

    public static int parseVarInt(InputStream data) throws IOException {
        int numRead = 0;
        int result = 0;
        byte read;
        do {
            int readInt = data.read();
            if (readInt == -1) {
                throw new RuntimeException("Not enough data");
            }
            read = (byte) readInt;
            int value = (read & 0b01111111);
            result |= (value << (7 * numRead));

            numRead++;
            if (numRead > 5) {
                throw new RuntimeException("VarInt is too big");
            }
        } while ((read & 0b10000000) != 0);

        return result;
    }

    public static String parseString(InputStream data) throws IOException {
        StringBuilder str = new StringBuilder();
        int length = Parser.parseVarInt(data);
        for(int i = 0; i < length; i++) {
            str.append((char) data.read());
        }
        return str.toString();
    }

    public static String parseChat(InputStream data) throws IOException {
        String chatMsg = parseString(data);
        try {
            JsonParser parser = new JsonParser();
            parser.parse(chatMsg);
        } catch (JsonSyntaxException jse) {
            throw new RuntimeException("Chat message is not a valid Json String:" + jse.getMessage());
        }
        return chatMsg;
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
}