package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class MultiBlockChangeParser extends AbstractPacketParser implements PacketParser {

    public MultiBlockChangeParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3B", "MultiBlockChangeParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Multi Block Change");
        return result;
    }
}
