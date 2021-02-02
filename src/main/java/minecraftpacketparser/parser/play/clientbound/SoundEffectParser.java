package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SoundEffectParser extends AbstractPacketParser implements PacketParser {

    public SoundEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x51", "SoundEffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Sound Effect");
        return result;
    }
}
