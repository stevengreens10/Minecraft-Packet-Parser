package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class KeepAliveServerBoundParser extends AbstractPacketParser implements PacketParser {

    public KeepAliveServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0F", "KeepAliveServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Keep Alive Server Bound");
        return result;
    }
}
