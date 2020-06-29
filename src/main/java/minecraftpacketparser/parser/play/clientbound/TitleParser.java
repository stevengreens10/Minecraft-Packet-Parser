package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TitleParser extends AbstractPacketParser implements PacketParser {

    public TitleParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x50", "TitleParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
