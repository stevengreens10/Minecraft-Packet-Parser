package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnExperienceOrbParser extends AbstractPacketParser implements PacketParser {

    public SpawnExperienceOrbParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x01", "SpawnExperienceOrbParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Experience Orb");
        return result;
    }
}
