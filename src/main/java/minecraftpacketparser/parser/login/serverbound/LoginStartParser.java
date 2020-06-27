package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class LoginStartParser extends AbstractPacketParser implements PacketParser {

    public LoginStartParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x00", "LoginStartParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
