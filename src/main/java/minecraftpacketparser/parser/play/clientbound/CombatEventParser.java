package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CombatEventParser extends AbstractPacketParser implements PacketParser {

    public CombatEventParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x33", "CombatEventParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
