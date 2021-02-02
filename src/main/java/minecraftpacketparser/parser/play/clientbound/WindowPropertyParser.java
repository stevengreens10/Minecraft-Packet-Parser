package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class WindowPropertyParser extends AbstractPacketParser implements PacketParser {

    public WindowPropertyParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x14", "WindowPropertyParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Window Property");
        return result;
    }
}
