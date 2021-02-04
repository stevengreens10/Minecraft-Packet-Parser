package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ScoreboardObjectiveParser extends AbstractPacketParser implements PacketParser {

    public ScoreboardObjectiveParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4A", "ScoreboardObjectiveParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Scoreboard Objective");
        return result;
    }
}
