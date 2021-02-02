package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class KeepAliveClientBoundParser extends AbstractPacketParser implements PacketParser {

    public KeepAliveClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1F", "KeepAliveClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Keep Alive Client Bound");
        return result;
    }
}
