package minecraftpacketparser.parser.status.clientbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PongParser extends AbstractPacketParser implements PacketParser {

    public PongParser() {
        super(State.STATUS, Direction.CLIENTBOUND, "0x01", "PongParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
	super.parse(data, output);
    }
}
