package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class StatusRequestParser extends AbstractPacketParser implements PacketParser {

    public StatusRequestParser() {
        super(State.STATUS, Direction.SERVERBOUND, "0x00", "StatusRequestParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
