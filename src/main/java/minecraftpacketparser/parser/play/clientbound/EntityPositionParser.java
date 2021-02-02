package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityPositionParser extends AbstractPacketParser implements PacketParser {

    public EntityPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x27", "EntityPositionParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Position");
        return result;
    }
}
