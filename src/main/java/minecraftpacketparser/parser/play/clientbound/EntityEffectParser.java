package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityEffectParser extends AbstractPacketParser implements PacketParser {

    public EntityEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x5A", "EntityEffectParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
