package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EffectParser extends AbstractPacketParser implements PacketParser {

    public EffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x23", "EffectParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Effect");
        return result;
    }
}
