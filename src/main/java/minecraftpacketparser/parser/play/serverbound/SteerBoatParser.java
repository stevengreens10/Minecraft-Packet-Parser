package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SteerBoatParser extends AbstractPacketParser implements PacketParser {

    public SteerBoatParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x17", "SteerBoatParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Steer Boat");
        return result;
    }
}
