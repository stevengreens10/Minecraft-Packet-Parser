package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class EffectParser extends AbstractPacketParser implements PacketParser {

    public EffectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x21", "EffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Effect");
        return result;
    }
}
