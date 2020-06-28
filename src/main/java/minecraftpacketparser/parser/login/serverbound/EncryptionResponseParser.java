package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EncryptionResponseParser extends AbstractPacketParser implements PacketParser {

    public EncryptionResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x01", "EncryptionResponseParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
