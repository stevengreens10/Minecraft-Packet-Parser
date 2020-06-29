package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class JoinGameParser extends AbstractPacketParser implements PacketParser {

    public JoinGameParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x26", "JoinGameParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
