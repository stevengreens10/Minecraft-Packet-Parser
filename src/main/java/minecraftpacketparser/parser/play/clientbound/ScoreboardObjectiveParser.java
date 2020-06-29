package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ScoreboardObjectiveParser extends AbstractPacketParser implements PacketParser {

    public ScoreboardObjectiveParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4A", "ScoreboardObjectiveParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
