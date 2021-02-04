package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SteerVehicleParser extends AbstractPacketParser implements PacketParser {

    public SteerVehicleParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1D", "SteerVehicleParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Steer Vehicle");
        return result;
    }
}
