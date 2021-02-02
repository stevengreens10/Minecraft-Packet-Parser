package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnPaintingParser extends AbstractPacketParser implements PacketParser {

    public SpawnPaintingParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x03", "SpawnPaintingParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Painting");
        return result;
    }
}
