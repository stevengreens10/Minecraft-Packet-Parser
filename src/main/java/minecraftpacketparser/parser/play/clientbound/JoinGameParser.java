package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class JoinGameParser extends AbstractPacketParser implements PacketParser {

    public JoinGameParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x24", "JoinGameParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        try {
            ParseResult result = new ParseResult("Join Game");
            result.packetFields.put("Entity ID", Parser.parseInt(data));
            result.packetFields.put("Hardcore?", Parser.parseBoolean(data));
            result.packetFields.put("Gamemode", Parser.parseUnsignedByte(data));
            result.packetFields.put("Previous Gamemode", Parser.parseByte(data));
            int worldCount = Parser.parseVarInt(data);
            result.packetFields.put("World Count", worldCount);

            for (int i = 0; i < worldCount; i++) {
                result.packetFields.put("\tWorld Name[" + i + "]", Parser.parseIdentifier(data));
            }

            result.packetFields.put("Dimension Codec", Parser.parseNBT(data));
            result.packetFields.put("Dimension", Parser.parseNBT(data));
            result.packetFields.put("Joining world", Parser.parseIdentifier(data));
            result.packetFields.put("Hashed Seed", Parser.parseLong(data));
            result.packetFields.put("Max Players", Parser.parseVarInt(data));
            result.packetFields.put("Render Distance", Parser.parseVarInt(data));
            result.packetFields.put("Reduced Debug Info?", Parser.parseBoolean(data));
            result.packetFields.put("Enable Respawn Screen?", Parser.parseBoolean(data));
            result.packetFields.put("Is Debug?", Parser.parseBoolean(data));
            result.packetFields.put("Is Flat?", Parser.parseBoolean(data));
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
