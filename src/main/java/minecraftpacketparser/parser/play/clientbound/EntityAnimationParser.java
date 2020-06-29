package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityAnimationParser extends AbstractPacketParser implements PacketParser {

    public EntityAnimationParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x06", "EntityAnimationParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
