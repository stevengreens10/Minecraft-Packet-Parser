package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityEquipmentParser extends AbstractPacketParser implements PacketParser {

    public EntityEquipmentParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x47", "EntityEquipmentParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Equipment");
        return result;
    }
}
