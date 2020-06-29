package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityActionParser extends AbstractPacketParser implements PacketParser {

    public EntityActionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1B", "EntityActionParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
