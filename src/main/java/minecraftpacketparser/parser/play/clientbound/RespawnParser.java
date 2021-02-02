package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class RespawnParser extends AbstractPacketParser implements PacketParser {

    public RespawnParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x39", "RespawnParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Respawn");
        result.packetFields.put("Dimension", Parser.parseNBT(data));
        result.packetFields.put("World Name", Parser.parseIdentifier(data));
        result.packetFields.put("Hashed Seed", Parser.parseLong(data));
        result.packetFields.put("Gamemode", Parser.parseUnsignedByte(data));
        result.packetFields.put("Previous Gamemode", Parser.parseUnsignedByte(data));
        result.packetFields.put("Debug?", Parser.parseBoolean(data));
        result.packetFields.put("Flat?", Parser.parseBoolean(data));
        result.packetFields.put("Copy Metadata?", Parser.parseBoolean(data));

        return result;
    }
}
