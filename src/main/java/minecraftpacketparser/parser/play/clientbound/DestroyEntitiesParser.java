package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class DestroyEntitiesParser extends AbstractPacketParser implements PacketParser {

    public DestroyEntitiesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x38", "DestroyEntitiesParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
