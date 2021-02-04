package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EncryptionRequestParser extends AbstractPacketParser implements PacketParser {

    public EncryptionRequestParser() {
        super(State.LOGIN, Direction.CLIENTBOUND, "0x01", "EncryptionRequestParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Encryption Request");
        return result;
    }
}
