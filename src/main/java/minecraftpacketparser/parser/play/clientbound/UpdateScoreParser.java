package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateScoreParser extends AbstractPacketParser implements PacketParser {

    public UpdateScoreParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4D", "UpdateScoreParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Score");
        return result;
    }
}
