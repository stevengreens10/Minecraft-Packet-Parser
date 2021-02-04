package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityActionParser extends AbstractPacketParser implements PacketParser {

    public EntityActionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1C", "EntityActionParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Action");
        return result;
    }
}
