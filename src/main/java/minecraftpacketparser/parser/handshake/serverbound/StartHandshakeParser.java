package minecraftpacketparser.parser.handshake.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class StartHandshakeParser extends AbstractPacketParser implements PacketParser {

    public StartHandshakeParser() {
        super(State.HANDSHAKE, Direction.SERVERBOUND, "0x00", "StartHandshakeParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
    super.parse(data, output);
        return null;
    }
}
