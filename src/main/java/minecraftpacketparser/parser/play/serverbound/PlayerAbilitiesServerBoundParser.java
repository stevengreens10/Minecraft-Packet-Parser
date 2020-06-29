package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerAbilitiesServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerAbilitiesServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x19", "PlayerAbilitiesServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
