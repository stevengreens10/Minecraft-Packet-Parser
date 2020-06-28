package minecraftpacketparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public interface PacketParser {

    ParseResult parse(InputStream data, PrintStream output) throws IOException;

}
