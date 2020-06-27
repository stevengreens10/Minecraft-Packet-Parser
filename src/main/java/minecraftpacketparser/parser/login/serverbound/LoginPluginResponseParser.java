package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class LoginPluginResponseParser extends AbstractPacketParser implements PacketParser {

    public LoginPluginResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x02", "LoginPluginResponseParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
