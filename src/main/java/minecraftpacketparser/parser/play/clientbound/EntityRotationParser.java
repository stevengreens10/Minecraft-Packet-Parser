package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityRotationParser extends AbstractPacketParser implements PacketParser {

    public EntityRotationParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x29", "EntityRotationParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Rotation");
        return result;
    }
}
