package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityAnimationParser extends AbstractPacketParser implements PacketParser {

    public EntityAnimationParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x05", "EntityAnimationParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Animation");
        return result;
    }
}
