package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class OpenHorseWindowParser extends AbstractPacketParser implements PacketParser {

    public OpenHorseWindowParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1E", "OpenHorseWindowParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Open Horse Window");
        return result;
    }
}
