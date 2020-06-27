package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class LoginPluginRequestParser extends AbstractPacketParser implements PacketParser {

    public LoginPluginRequestParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x04", "LoginPluginRequestParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
