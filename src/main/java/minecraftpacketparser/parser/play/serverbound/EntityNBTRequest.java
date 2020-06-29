package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityNBTRequest extends AbstractPacketParser implements PacketParser {

    public EntityNBTRequest(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0D", "EntityNBTRequest");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
