package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpawnWeatherEntityParser extends AbstractPacketParser implements PacketParser {

    public SpawnWeatherEntityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x02", "SpawnWeatherEntityParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spawn Weather Entity");
        return result;
    }
}
