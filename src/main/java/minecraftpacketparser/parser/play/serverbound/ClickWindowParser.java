package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ClickWindowParser extends AbstractPacketParser implements PacketParser {

    public ClickWindowParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x09", "ClickWindowParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Click Window");
        return result;
    }
}
