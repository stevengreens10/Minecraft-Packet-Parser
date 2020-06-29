package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LoginPluginResponseParser extends AbstractPacketParser implements PacketParser {

    public LoginPluginResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x02", "LoginPluginResponseParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
