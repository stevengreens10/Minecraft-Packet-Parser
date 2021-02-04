package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;
import minecraftpacketparser.parser.datatype.EntityMetadata;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityMetadataParser extends AbstractPacketParser implements PacketParser {

    public EntityMetadataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x44", "EntityMetadataParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Metadata");

        result.packetFields.put("Entity ID", Parser.parseVarInt(data));

        List<EntityMetadata> metadataEntries = new ArrayList<>();
        EntityMetadata metadata;
        do {
            metadata = Parser.parseEntityMetadata(data);
            metadataEntries.add(metadata);
        } while(metadata.index != 0xFF);

        result.packetFields.put("Entity Metadata", Arrays.deepToString(metadataEntries.toArray()));

        return result;
    }
}
