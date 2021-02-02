package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EncryptionResponseParser extends AbstractPacketParser implements PacketParser {

    public EncryptionResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x01", "EncryptionResponseParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Encryption Response");
        return result;
    }
}
