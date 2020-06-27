package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PlayerPosAndLookServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerPosAndLookServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x12", "PlayerPosAndLookServerBoundParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
