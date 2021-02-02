package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SteerVehicleParser extends AbstractPacketParser implements PacketParser {

    public SteerVehicleParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1D", "SteerVehicleParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Steer Vehicle");
        return result;
    }
}
