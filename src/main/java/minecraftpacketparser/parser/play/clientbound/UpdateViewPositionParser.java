package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UpdateViewPositionParser extends AbstractPacketParser implements PacketParser {

    public UpdateViewPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x40", "UpdateViewPositionParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);

        int chunkX = Parser.parseVarInt(data);
        int chunkY = Parser.parseVarInt(data);

        ParseResult result = new ParseResult("Update View Position");
        result.packetFields.put("Chunk X", chunkX);
        result.packetFields.put("Chunk Y", chunkY);

        return result;
    }
}
