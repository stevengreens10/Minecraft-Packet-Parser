package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class NamedSoundEffectParser extends AbstractPacketParser implements PacketParser {

    public NamedSoundEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1A", "NamedSoundEffectParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Named Sound Effect");
        return result;
    }
}
