package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityMetadataParser extends AbstractPacketParser implements PacketParser {

    public EntityMetadataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x44", "EntityMetadataParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
