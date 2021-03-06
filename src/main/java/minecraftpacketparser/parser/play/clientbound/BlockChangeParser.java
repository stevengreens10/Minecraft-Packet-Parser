package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class BlockChangeParser extends AbstractPacketParser implements PacketParser {

    public BlockChangeParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0B", "BlockChangeParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Block Change");
        return result;
    }
}
