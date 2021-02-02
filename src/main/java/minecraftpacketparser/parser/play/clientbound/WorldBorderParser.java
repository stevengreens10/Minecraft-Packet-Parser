package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class WorldBorderParser extends AbstractPacketParser implements PacketParser {

    public WorldBorderParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3D", "WorldBorderParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("World Border");
        return result;
    }
}
