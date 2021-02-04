package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UnloadChunkParser extends AbstractPacketParser implements PacketParser {

    public UnloadChunkParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1C", "UnloadChunkParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Unload Chunk");
        return result;
    }
}
