package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SoundEffectParser extends AbstractPacketParser implements PacketParser {

    public SoundEffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x52", "SoundEffectParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
