package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TabCompleteClientBoundParser extends AbstractPacketParser implements PacketParser {

    public TabCompleteClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0F", "TabCompleteClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Tab Complete Client Bound");
        return result;
    }
}
