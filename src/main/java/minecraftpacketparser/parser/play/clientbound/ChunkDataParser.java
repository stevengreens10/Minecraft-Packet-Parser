package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ChunkDataParser extends AbstractPacketParser implements PacketParser {

    public ChunkDataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x22", "ChunkDataParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        
        return null;
    }
}
