package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityEquipmentParser extends AbstractPacketParser implements PacketParser {

    public EntityEquipmentParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x47", "EntityEquipmentParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
