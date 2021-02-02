package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EffectParser extends AbstractPacketParser implements PacketParser {

    public EffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x21", "EffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Effect");
        return result;
    }
}
