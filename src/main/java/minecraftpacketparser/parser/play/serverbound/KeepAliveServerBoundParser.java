package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class KeepAliveServerBoundParser extends AbstractPacketParser implements PacketParser {

    public KeepAliveServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x10", "KeepAliveServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Keep Alive Server Bound");
        return result;
    }
}
