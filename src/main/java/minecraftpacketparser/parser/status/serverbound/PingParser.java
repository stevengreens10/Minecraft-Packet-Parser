package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PingParser extends AbstractPacketParser implements PacketParser {

    public PingParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x01", "PingParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
