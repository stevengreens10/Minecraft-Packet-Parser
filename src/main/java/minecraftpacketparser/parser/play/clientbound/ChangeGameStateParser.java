package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ChangeGameStateParser extends AbstractPacketParser implements PacketParser {

    public ChangeGameStateParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1F", "ChangeGameStateParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
