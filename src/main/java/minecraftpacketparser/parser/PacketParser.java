package minecraftpacketparser.parser;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public interface PacketParser {

    ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException;

}
