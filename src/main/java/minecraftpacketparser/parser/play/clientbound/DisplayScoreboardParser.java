package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class DisplayScoreboardParser extends AbstractPacketParser implements PacketParser {

    public DisplayScoreboardParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x43", "DisplayScoreboardParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Display Scoreboard");
        return result;
    }
}
