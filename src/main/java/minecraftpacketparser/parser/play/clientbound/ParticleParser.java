package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ParticleParser extends AbstractPacketParser implements PacketParser {

    public ParticleParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x22", "ParticleParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Particle");
        return result;
    }
}
