package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayDisconnectParser extends AbstractPacketParser implements PacketParser {

    public PlayDisconnectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1B", "PlayDisconnectParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
