package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TimeUpdateParser extends AbstractPacketParser implements PacketParser {

    public TimeUpdateParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4F", "TimeUpdateParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
