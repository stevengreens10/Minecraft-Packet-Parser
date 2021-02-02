package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TitleParser extends AbstractPacketParser implements PacketParser {

    public TitleParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4F", "TitleParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Title");
        return result;
    }
}
