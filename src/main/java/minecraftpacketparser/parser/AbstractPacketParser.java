package minecraftpacketparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public abstract class AbstractPacketParser implements PacketParser {
    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
        output.println("\tHandled.");
    }
}
