package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EntityPositionAndRotationParser extends AbstractPacketParser implements PacketParser {

    public EntityPositionAndRotationParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2A", "EntityPositionAndRotationParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Entity Position and Rotation");

        int entityID = Parser.parseVarInt(data);
        short deltaX = Parser.parseShort(data);
        short deltaY = Parser.parseShort(data);
        short deltaZ = Parser.parseShort(data);
        int yaw = Parser.parseAngle(data);
        int pitch = Parser.parseAngle(data);
        boolean onGround = Parser.parseBoolean(data);

        result.packetFields.put("Entity ID", entityID);
        result.packetFields.put("Delta X", deltaX);
        result.packetFields.put("Delta Y", deltaY);
        result.packetFields.put("Delta Z", deltaZ);
        result.packetFields.put("Yaw", yaw);
        result.packetFields.put("Pitch", pitch);
        result.packetFields.put("On Ground?", onGround);

        return result;
    }
}
