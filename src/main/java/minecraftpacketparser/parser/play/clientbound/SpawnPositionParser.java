package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnPositionParser extends AbstractPacketParser implements PacketParser {

    public SpawnPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4E", "SpawnPositionParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
