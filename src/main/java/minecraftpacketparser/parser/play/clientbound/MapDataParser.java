package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class MapDataParser extends AbstractPacketParser implements PacketParser {

    public MapDataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x27", "MapDataParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
