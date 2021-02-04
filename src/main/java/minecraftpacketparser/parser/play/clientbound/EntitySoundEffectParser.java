package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntitySoundEffectParser extends AbstractPacketParser implements PacketParser {

    public EntitySoundEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x50", "EntitySoundEffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Sound Effect");
        return result;
    }
}
