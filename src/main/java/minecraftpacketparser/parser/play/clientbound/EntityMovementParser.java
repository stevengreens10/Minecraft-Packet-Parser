package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityMovementParser extends AbstractPacketParser implements PacketParser {

    public EntityMovementParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2A", "EntityMovementParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Movement");
        return result;
    }
}
