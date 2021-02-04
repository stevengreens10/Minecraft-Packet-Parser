package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityTeleportParser extends AbstractPacketParser implements PacketParser {

    public EntityTeleportParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x56", "EntityTeleportParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Teleport");
        return result;
    }
}
