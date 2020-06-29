package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnLivingEntityParser extends AbstractPacketParser implements PacketParser {

    public SpawnLivingEntityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x03", "SpawnLivingEntityParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Spawn Living Entity");
        return result;
    }
}
