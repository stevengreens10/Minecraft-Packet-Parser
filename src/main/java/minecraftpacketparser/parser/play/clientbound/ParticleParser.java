package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ParticleParser extends AbstractPacketParser implements PacketParser {

    public ParticleParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x24", "ParticleParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Particle");
        return result;
    }
}
