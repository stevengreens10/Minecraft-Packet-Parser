package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UnloadChunkParser extends AbstractPacketParser implements PacketParser {

    public UnloadChunkParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1C", "UnloadChunkParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Unload Chunk");
        return result;
    }
}
