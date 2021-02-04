package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SpawnExperienceOrbParser extends AbstractPacketParser implements PacketParser {

    public SpawnExperienceOrbParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x01", "SpawnExperienceOrbParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Experience Orb");
        return result;
    }
}
