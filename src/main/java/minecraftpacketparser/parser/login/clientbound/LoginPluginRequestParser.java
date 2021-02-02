package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LoginPluginRequestParser extends AbstractPacketParser implements PacketParser {

    public LoginPluginRequestParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x04", "LoginPluginRequestParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Login Plugin Request");
        return result;
    }
}
