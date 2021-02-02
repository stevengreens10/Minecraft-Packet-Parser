package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ChunkDataParser extends AbstractPacketParser implements PacketParser {

    public ChunkDataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x20", "ChunkDataParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Chunk Data");
        return result;
    }
}
