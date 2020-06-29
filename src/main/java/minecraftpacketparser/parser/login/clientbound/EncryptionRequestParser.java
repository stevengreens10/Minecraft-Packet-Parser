package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EncryptionRequestParser extends AbstractPacketParser implements PacketParser {

    public EncryptionRequestParser() {
        super(State.LOGIN, Direction.CLIENTBOUND, "0x01", "EncryptionRequestParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
