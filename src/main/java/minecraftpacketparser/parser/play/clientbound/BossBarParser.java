package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class BossBarParser extends AbstractPacketParser implements PacketParser {

    public BossBarParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0D", "BossBarParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
