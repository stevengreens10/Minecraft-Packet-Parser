package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StatusRequestParser extends AbstractPacketParser implements PacketParser {

    public StatusRequestParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x00", "StatusRequestParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
