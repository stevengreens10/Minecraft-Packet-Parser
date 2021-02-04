package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PingParser extends AbstractPacketParser implements PacketParser {

    public PingParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x01", "PingParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Ping");
        return result;
    }
}
