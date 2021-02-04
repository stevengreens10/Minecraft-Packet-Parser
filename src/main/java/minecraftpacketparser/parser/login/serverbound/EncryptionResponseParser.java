package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EncryptionResponseParser extends AbstractPacketParser implements PacketParser {

    public EncryptionResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x01", "EncryptionResponseParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Encryption Response");
        return result;
    }
}
