package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EntityStatusParser extends AbstractPacketParser implements PacketParser {

    public EntityStatusParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1A", "EntityStatusParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Entity Status");
        result.packetFields.put("Entity ID", Parser.parseInt(data));
        result.packetFields.put("Entity Status", Parser.parseByte(data));
        return result;
    }
}
