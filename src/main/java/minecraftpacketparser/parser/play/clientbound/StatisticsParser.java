package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class StatisticsParser extends AbstractPacketParser implements PacketParser {

    public StatisticsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x06", "StatisticsParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Statistics");
        return result;
    }
}
