package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetCooldownParser extends AbstractPacketParser implements PacketParser {

    public SetCooldownParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x18", "SetCooldownParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
