package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class StatusRequestParser extends AbstractPacketParser implements PacketParser {

    public StatusRequestParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x00", "StatusRequestParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
