package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityPositionParser extends AbstractPacketParser implements PacketParser {

    public EntityPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x27", "EntityPositionParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Position");
        return result;
    }
}
