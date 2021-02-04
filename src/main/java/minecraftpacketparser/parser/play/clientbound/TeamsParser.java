package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TeamsParser extends AbstractPacketParser implements PacketParser {

    public TeamsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4C", "TeamsParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Teams");
        return result;
    }
}
