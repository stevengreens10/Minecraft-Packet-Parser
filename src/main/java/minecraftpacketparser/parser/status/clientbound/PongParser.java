package minecraftpacketparser.parser.status.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PongParser extends AbstractPacketParser implements PacketParser {

    public PongParser() {
        super(State.STATUS, Direction.CLIENTBOUND, "0x01", "PongParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
	super.parse(data, output);
    	return null;
	}
}
