package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EntityPositionAndRotationParser extends AbstractPacketParser implements PacketParser {

    public EntityPositionAndRotationParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2A", "EntityPositionAndRotationParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
		int entityID = Parser.parseVarInt(data);
		short deltaX = Parser.parseShort(data);
		short deltaY = Parser.parseShort(data);
		short deltaZ = Parser.parseShort(data);
		int yaw = Parser.parseAngle(data);
		int pitch = Parser.parseAngle(data);
		boolean onGround = Parser.parseBoolean(data);
		output.printf("\tEntity ID: %d\n", entityID);
		output.printf("\tDelta X: %d\n", deltaX);
		output.printf("\tDelta Y: %d\n", deltaY);
		output.printf("\tDelta Z: %d\n", deltaZ);
		output.printf("\tYaw: %d\n", yaw);
		output.printf("\tPitch: %d\n", pitch);
		output.printf("\tOn Ground?: %s\n", onGround ? "true" : "false");
    }
}
