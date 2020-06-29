package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StopSoundParser extends AbstractPacketParser implements PacketParser {

    public StopSoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x53", "StopSoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Stop Sound");
        return result;
    }
}
