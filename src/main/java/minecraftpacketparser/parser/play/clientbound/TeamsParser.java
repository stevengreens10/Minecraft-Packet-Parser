package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TeamsParser extends AbstractPacketParser implements PacketParser {

    public TeamsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4C", "TeamsParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Teams");
        return result;
    }
}
