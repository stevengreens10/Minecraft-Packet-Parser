package minecraftpacketparser.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public interface PacketParser {

    void parse(InputStream data, PrintStream output) throws IOException;

}
