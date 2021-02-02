package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityRotationParser extends AbstractPacketParser implements PacketParser {

    public EntityRotationParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x29", "EntityRotationParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Rotation");
        return result;
    }
}
