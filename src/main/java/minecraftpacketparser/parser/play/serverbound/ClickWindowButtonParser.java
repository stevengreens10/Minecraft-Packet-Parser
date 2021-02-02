package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ClickWindowButtonParser extends AbstractPacketParser implements PacketParser {

    public ClickWindowButtonParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x08", "ClickWindowButtonParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Click Window Button");
        return result;
    }
}
