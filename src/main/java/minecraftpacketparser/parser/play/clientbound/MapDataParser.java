package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class MapDataParser extends AbstractPacketParser implements PacketParser {

    public MapDataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x25", "MapDataParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Map Data");
        return result;
    }
}
