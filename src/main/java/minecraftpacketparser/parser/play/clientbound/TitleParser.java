package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TitleParser extends AbstractPacketParser implements PacketParser {

    public TitleParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4F", "TitleParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Title");
        return result;
    }
}
