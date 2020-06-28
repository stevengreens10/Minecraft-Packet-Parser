package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class PlayerPositionParser extends AbstractPacketParser implements PacketParser {

    public PlayerPositionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x11", "PlayerPositionParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
