package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LoginStartParser extends AbstractPacketParser implements PacketParser {

    public LoginStartParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x00", "LoginStartParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
