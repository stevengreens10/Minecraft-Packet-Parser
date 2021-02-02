package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityMetadataParser extends AbstractPacketParser implements PacketParser {

    public EntityMetadataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x44", "EntityMetadataParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Metadata");
        return result;
    }
}
