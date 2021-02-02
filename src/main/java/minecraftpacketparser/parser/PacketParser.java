package minecraftpacketparser.parser;

import java.io.IOException;
import java.io.InputStream;

public interface PacketParser {

    ParseResult parse(Parser parser, InputStream data) throws IOException;

}
