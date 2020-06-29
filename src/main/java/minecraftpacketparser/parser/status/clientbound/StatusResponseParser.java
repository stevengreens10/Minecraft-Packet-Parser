package minecraftpacketparser.parser.status.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StatusResponseParser extends AbstractPacketParser implements PacketParser {

    public StatusResponseParser() {
        super(State.STATUS, Direction.CLIENTBOUND, "0x00", "StatusResponseParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("StatusResponse    ");
        return result;
    }
}
