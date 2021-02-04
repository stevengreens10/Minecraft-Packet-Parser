package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class OpenWindowParser extends AbstractPacketParser implements PacketParser {

    public OpenWindowParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2D", "OpenWindowParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Open Window");
        return result;
    }
}
