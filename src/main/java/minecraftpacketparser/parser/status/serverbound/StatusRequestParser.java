package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StatusRequestParser extends AbstractPacketParser implements PacketParser {

    public StatusRequestParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x00", "StatusRequestParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Status Request");
        return result;
    }
}
