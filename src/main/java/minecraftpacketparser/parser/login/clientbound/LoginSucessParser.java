package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class LoginSucessParser extends AbstractPacketParser implements PacketParser {

    public LoginSucessParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x02", "LoginSucessParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
