package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class SpawnWeatherEntityParser extends AbstractPacketParser implements PacketParser {

    public SpawnWeatherEntityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x02", "SpawnWeatherEntityParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
