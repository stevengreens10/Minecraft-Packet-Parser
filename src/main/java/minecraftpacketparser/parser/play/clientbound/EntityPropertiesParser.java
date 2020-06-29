package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityPropertiesParser extends AbstractPacketParser implements PacketParser {

    public EntityPropertiesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x59", "EntityPropertiesParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Entity Properties");
        return result;
    }
}
