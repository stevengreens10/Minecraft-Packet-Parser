package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class AckPlayerDiggingParser extends AbstractPacketParser implements PacketParser {

    public AckPlayerDiggingParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x08", "AckPlayerDiggingParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        
        return null;
    }
}
