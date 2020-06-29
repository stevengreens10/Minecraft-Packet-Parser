package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class VehicleMoveClientBoundParser extends AbstractPacketParser implements PacketParser {

    public VehicleMoveClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2D", "VehicleMoveClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
