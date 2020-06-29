package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UnloadChunkParser extends AbstractPacketParser implements PacketParser {

    public UnloadChunkParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1E", "UnloadChunkParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
