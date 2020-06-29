package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TabCompleteClientBoundParser extends AbstractPacketParser implements PacketParser {

    public TabCompleteClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x11", "TabCompleteClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
