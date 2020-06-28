package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class LoginPluginResponseParser extends AbstractPacketParser implements PacketParser {

    public LoginPluginResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x02", "LoginPluginResponseParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
