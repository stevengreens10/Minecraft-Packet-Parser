package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class AdvancementTabParser extends AbstractPacketParser implements PacketParser {

    public AdvancementTabParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x20", "AdvancementTabParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
