package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpectateParser extends AbstractPacketParser implements PacketParser {

    public SpectateParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2B", "SpectateParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Spectate");
        return result;
    }
}
