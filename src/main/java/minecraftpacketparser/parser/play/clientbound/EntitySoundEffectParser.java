package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntitySoundEffectParser extends AbstractPacketParser implements PacketParser {

    public EntitySoundEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x50", "EntitySoundEffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Sound Effect");
        return result;
    }
}
