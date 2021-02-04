package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BlockBreakAnimParser extends AbstractPacketParser implements PacketParser {

    public BlockBreakAnimParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x08", "BlockBreakAnimParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Block Break Anim");
        return result;
    }
}
