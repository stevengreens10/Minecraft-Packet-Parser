package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ParticleParser extends AbstractPacketParser implements PacketParser {

    public ParticleParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x22", "ParticleParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Particle");
        return result;
    }
}
