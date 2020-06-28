package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PlayerPosAndLookServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerPosAndLookServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x12", "PlayerPosAndLookServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
