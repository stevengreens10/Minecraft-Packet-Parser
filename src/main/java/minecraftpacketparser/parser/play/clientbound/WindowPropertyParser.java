package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class WindowPropertyParser extends AbstractPacketParser implements PacketParser {

    public WindowPropertyParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x14", "WindowPropertyParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Window Property");
        return result;
    }
}
