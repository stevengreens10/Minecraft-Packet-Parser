package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class VehicleMoveClientBoundParser extends AbstractPacketParser implements PacketParser {

    public VehicleMoveClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2B", "VehicleMoveClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Vehicle Move Client Bound");
        return result;
    }
}
