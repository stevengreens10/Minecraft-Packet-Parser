package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SteerBoatParser extends AbstractPacketParser implements PacketParser {

    public SteerBoatParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x17", "SteerBoatParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Steer Boat");
        return result;
    }
}
