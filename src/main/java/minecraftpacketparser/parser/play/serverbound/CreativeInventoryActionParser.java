package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class CreativeInventoryActionParser extends AbstractPacketParser implements PacketParser {

    public CreativeInventoryActionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x26", "CreativeInventoryActionParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
