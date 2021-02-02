package minecraftpacketparser.parser.status.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PongParser extends AbstractPacketParser implements PacketParser {

    public PongParser() {
        super(State.STATUS, Direction.CLIENTBOUND, "0x01", "PongParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Pong");
        return result;
    }
}
