package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SpawnLivingEntityParser extends AbstractPacketParser implements PacketParser {

    public SpawnLivingEntityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x02", "SpawnLivingEntityParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Living Entity");
        return result;
    }
}
