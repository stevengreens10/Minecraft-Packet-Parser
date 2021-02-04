package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SpectateParser extends AbstractPacketParser implements PacketParser {

    public SpectateParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2D", "SpectateParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Spectate");
        return result;
    }
}
