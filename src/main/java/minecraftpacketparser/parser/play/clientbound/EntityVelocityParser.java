package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityVelocityParser extends AbstractPacketParser implements PacketParser {

    public EntityVelocityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x46", "EntityVelocityParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Velocity");
        return result;
    }
}
