package minecraftpacketparser.parser.handshake.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StartHandshakeParser extends AbstractPacketParser implements PacketParser {

    public StartHandshakeParser() {
        super(State.HANDSHAKE, Direction.SERVERBOUND, "0x00", "StartHandshakeParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("StartHandshake    ");
        return result;
    }
}
