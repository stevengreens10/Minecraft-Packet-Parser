package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ClickWindowParser extends AbstractPacketParser implements PacketParser {

    public ClickWindowParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x09", "ClickWindowParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Click Window");
        return result;
    }
}
