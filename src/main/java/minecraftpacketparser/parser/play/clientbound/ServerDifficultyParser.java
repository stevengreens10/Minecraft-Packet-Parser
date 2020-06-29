package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ServerDifficultyParser extends AbstractPacketParser implements PacketParser {

    public ServerDifficultyParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0E", "ServerDifficultyParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
