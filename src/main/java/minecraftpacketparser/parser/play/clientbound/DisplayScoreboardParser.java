package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DisplayScoreboardParser extends AbstractPacketParser implements PacketParser {

    public DisplayScoreboardParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x43", "DisplayScoreboardParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Display Scoreboard");
        return result;
    }
}
