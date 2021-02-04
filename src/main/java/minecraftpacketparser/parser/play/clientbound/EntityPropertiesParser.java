package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityPropertiesParser extends AbstractPacketParser implements PacketParser {

    public EntityPropertiesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x58", "EntityPropertiesParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Properties");
        return result;
    }
}
