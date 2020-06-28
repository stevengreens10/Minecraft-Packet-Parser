package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EncryptionRequestParser extends AbstractPacketParser implements PacketParser {

    public EncryptionRequestParser() {
        super(State.LOGIN, Direction.CLIENTBOUND, "0x01", "EncryptionRequestParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
