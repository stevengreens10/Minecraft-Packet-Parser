package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ExplosionParser extends AbstractPacketParser implements PacketParser {

    public ExplosionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1B", "ExplosionParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Explosion");
        return result;
    }
}
