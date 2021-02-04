package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class KeepAliveServerBoundParser extends AbstractPacketParser implements PacketParser {

    public KeepAliveServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x10", "KeepAliveServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Keep Alive Server Bound");
        return result;
    }
}
