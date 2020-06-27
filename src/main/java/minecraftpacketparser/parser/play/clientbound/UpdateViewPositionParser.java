package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.Parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class UpdateViewPositionParser extends AbstractPacketParser implements PacketParser {
    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        output.println("\tUpdate view position.");
        output.println("\tChunk X: " + Parser.parseVarInt(data));
        output.println("\tChunk Y: " + Parser.parseVarInt(data));
    }
}
