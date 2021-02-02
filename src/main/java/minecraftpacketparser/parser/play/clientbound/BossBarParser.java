package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class BossBarParser extends AbstractPacketParser implements PacketParser {

    public BossBarParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0C", "BossBarParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Boss Bar");
        return result;
    }
}
