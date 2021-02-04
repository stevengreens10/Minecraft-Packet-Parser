package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SoundEffectParser extends AbstractPacketParser implements PacketParser {

    public SoundEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x51", "SoundEffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Sound Effect");
        return result;
    }
}
