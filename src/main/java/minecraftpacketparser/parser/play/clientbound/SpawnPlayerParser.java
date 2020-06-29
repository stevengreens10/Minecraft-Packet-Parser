package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnPlayerParser extends AbstractPacketParser implements PacketParser {

    public SpawnPlayerParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x05", "SpawnPlayerParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
