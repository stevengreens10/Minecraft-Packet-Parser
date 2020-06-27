package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class WindowPropertyParser extends AbstractPacketParser implements PacketParser {

    public WindowPropertyParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x16", "WindowPropertyParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
