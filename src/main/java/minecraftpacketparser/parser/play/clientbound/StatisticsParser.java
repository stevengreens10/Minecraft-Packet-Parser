package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StatisticsParser extends AbstractPacketParser implements PacketParser {

    public StatisticsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x06", "StatisticsParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Statistics");
        return result;
    }
}
