package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class VehicleMoveServerBoundParser extends AbstractPacketParser implements PacketParser {

    public VehicleMoveServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x16", "VehicleMoveServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Vehicle Move Server Bound");
        return result;
    }
}
