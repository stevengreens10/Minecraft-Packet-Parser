package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PingParser extends AbstractPacketParser implements PacketParser {

    public PingParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x01", "PingParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Ping");
        return result;
    }
}
