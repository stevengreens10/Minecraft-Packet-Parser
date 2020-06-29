package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LoginSucessParser extends AbstractPacketParser implements PacketParser {

    public LoginSucessParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x02", "LoginSucessParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
