package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SpawnEntityParser extends AbstractPacketParser implements PacketParser {

    public SpawnEntityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x00", "SpawnEntityParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Entity");
        result.packetFields.put("Entity ID", Parser.parseVarInt(data));
        result.packetFields.put("Object UUID", Parser.parseUUID(data));
        result.packetFields.put("Entity Type", Parser.parseVarInt(data));
        result.packetFields.put("X", Parser.parseDouble(data));
        result.packetFields.put("Y", Parser.parseDouble(data));
        result.packetFields.put("Z", Parser.parseDouble(data));
        result.packetFields.put("Pitch", Parser.parseAngle(data));
        result.packetFields.put("Yaw", Parser.parseAngle(data));
        result.packetFields.put("Delta", Parser.parseInt(data));
        result.packetFields.put("Velocity X", Parser.parseShort(data));
        result.packetFields.put("Velocity Y", Parser.parseShort(data));
        result.packetFields.put("Velocity Z", Parser.parseShort(data));
        return result;
    }
}
