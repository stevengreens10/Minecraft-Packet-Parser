package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.PacketParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class SetDifficultyParser extends AbstractPacketParser implements PacketParser {
    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
