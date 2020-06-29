package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class WindowItemsParser extends AbstractPacketParser implements PacketParser {

    public WindowItemsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x15", "WindowItemsParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
