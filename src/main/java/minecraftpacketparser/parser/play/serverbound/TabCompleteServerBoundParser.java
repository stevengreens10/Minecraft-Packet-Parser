package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TabCompleteServerBoundParser extends AbstractPacketParser implements PacketParser {

    public TabCompleteServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x06", "TabCompleteServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Tab Complete Server Bound");
        return result;
    }
}
