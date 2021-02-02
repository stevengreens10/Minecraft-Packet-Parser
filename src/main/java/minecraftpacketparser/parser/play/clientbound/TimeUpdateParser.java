package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TimeUpdateParser extends AbstractPacketParser implements PacketParser {

    public TimeUpdateParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4E", "TimeUpdateParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Time Update");
        return result;
    }
}
