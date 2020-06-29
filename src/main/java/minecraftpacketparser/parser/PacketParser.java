package minecraftpacketparser.parser;

import java.io.IOException;
import java.io.InputStream;

public interface PacketParser {

    ParseResult parse(InputStream data) throws IOException;

}
