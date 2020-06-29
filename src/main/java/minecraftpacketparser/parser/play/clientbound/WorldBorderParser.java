package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class WorldBorderParser extends AbstractPacketParser implements PacketParser {

    public WorldBorderParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3E", "WorldBorderParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("World Border");
        return result;
    }
}
