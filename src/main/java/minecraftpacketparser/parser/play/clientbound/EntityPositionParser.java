package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityPositionParser extends AbstractPacketParser implements PacketParser {

    public EntityPositionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x29", "EntityPositionParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
