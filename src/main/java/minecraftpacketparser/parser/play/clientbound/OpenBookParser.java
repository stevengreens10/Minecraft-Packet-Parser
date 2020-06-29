package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class OpenBookParser extends AbstractPacketParser implements PacketParser {

    public OpenBookParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2E", "OpenBookParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
