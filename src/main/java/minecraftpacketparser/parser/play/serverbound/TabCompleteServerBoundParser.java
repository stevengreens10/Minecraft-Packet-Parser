package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TabCompleteServerBoundParser extends AbstractPacketParser implements PacketParser {

    public TabCompleteServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x06", "TabCompleteServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
