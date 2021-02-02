package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityTeleportParser extends AbstractPacketParser implements PacketParser {

    public EntityTeleportParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x56", "EntityTeleportParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Teleport");
        return result;
    }
}
