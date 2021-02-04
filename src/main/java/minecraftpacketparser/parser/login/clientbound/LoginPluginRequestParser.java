package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoginPluginRequestParser extends AbstractPacketParser implements PacketParser {

    public LoginPluginRequestParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x04", "LoginPluginRequestParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Login Plugin Request");
        return result;
    }
}
