package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SpectateParser extends AbstractPacketParser implements PacketParser {

    public SpectateParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2D", "SpectateParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spectate");
        return result;
    }
}
