package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LoginDisconnectParser extends AbstractPacketParser implements PacketParser {

    public LoginDisconnectParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x00", "LoginDisconnectParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Login Disconnect");
        return result;
    }
}
