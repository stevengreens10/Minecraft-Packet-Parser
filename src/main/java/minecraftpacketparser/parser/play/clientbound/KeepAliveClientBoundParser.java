package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class KeepAliveClientBoundParser extends AbstractPacketParser implements PacketParser {

    public KeepAliveClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x21", "KeepAliveClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Keep Alive Client Bound");
        return result;
    }
}
