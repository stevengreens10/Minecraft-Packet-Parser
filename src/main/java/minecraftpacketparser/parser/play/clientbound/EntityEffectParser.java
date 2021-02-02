package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityEffectParser extends AbstractPacketParser implements PacketParser {

    public EntityEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x59", "EntityEffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Effect");
        return result;
    }
}
