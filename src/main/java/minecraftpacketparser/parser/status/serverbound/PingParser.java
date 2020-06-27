package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PingParser extends AbstractPacketParser implements PacketParser {

    public PingParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x01", "PingParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
