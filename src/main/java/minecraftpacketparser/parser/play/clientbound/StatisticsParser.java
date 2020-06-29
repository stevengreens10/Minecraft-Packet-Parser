package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StatisticsParser extends AbstractPacketParser implements PacketParser {

    public StatisticsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x07", "StatisticsParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Statistics");
        return result;
    }
}
