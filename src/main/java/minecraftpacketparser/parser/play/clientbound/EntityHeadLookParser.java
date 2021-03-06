package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityHeadLookParser extends AbstractPacketParser implements PacketParser {

    public EntityHeadLookParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3A", "EntityHeadLookParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Head Look");
        return result;
    }
}
