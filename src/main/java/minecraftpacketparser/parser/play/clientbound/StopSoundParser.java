package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StopSoundParser extends AbstractPacketParser implements PacketParser {

    public StopSoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x52", "StopSoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Stop Sound");
        return result;
    }
}
