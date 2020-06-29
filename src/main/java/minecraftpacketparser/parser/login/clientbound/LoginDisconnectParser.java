package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LoginDisconnectParser extends AbstractPacketParser implements PacketParser {

    public LoginDisconnectParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x00", "LoginDisconnectParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
