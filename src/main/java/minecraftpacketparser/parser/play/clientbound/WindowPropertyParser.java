package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class WindowPropertyParser extends AbstractPacketParser implements PacketParser {

    public WindowPropertyParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x16", "WindowPropertyParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
