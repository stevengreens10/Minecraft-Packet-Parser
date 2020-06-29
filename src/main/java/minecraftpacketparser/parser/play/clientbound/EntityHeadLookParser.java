package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityHeadLookParser extends AbstractPacketParser implements PacketParser {

    public EntityHeadLookParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3C", "EntityHeadLookParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
