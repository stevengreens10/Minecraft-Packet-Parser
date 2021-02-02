package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetExperienceParser extends AbstractPacketParser implements PacketParser {

    public SetExperienceParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x48", "SetExperienceParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Experience");
        return result;
    }
}
