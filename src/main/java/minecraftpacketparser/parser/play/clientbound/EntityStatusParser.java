package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityStatusParser extends AbstractPacketParser implements PacketParser {

    public EntityStatusParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1C", "EntityStatusParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
