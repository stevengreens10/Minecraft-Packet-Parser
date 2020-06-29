package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerRotationParser extends AbstractPacketParser implements PacketParser {

    public PlayerRotationParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x13", "PlayerRotationParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
