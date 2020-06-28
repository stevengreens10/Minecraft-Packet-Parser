package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class RespawnParser extends AbstractPacketParser implements PacketParser {

    public RespawnParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3B", "RespawnParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
