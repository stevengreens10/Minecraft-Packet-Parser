package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ExplosionParser extends AbstractPacketParser implements PacketParser {

    public ExplosionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1D", "ExplosionParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
