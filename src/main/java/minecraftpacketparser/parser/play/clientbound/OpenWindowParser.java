package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class OpenWindowParser extends AbstractPacketParser implements PacketParser {

    public OpenWindowParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2F", "OpenWindowParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
