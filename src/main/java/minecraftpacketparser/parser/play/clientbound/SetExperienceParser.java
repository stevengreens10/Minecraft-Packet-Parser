package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SetExperienceParser extends AbstractPacketParser implements PacketParser {

    public SetExperienceParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x48", "SetExperienceParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Experience");
        return result;
    }
}
