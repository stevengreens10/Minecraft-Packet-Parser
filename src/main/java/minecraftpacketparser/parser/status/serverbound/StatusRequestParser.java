package minecraftpacketparser.parser.status.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.PacketParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class StatusRequestParser extends AbstractPacketParser implements PacketParser {
    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
