package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoginPluginResponseParser extends AbstractPacketParser implements PacketParser {

    public LoginPluginResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x02", "LoginPluginResponseParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Login Plugin Response");
        return result;
    }
}
