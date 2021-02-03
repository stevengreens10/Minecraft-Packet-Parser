package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnPlayerParser extends AbstractPacketParser implements PacketParser {

    public SpawnPlayerParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x04", "SpawnPlayerParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Player");
        result.packetFields.put("Entity ID", Parser.parseVarInt(data));
        result.packetFields.put("Player UUID", Parser.parseUUID(data));
        result.packetFields.put("X", Parser.parseDouble(data));
        result.packetFields.put("Y", Parser.parseDouble(data));
        result.packetFields.put("Z", Parser.parseDouble(data));
        result.packetFields.put("Yaw", Parser.parseAngle(data));
        result.packetFields.put("Angle", Parser.parseAngle(data));
        return result;
    }
}
