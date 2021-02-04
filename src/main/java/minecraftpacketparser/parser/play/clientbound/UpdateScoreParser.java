package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UpdateScoreParser extends AbstractPacketParser implements PacketParser {

    public UpdateScoreParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4D", "UpdateScoreParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Score");
        return result;
    }
}
