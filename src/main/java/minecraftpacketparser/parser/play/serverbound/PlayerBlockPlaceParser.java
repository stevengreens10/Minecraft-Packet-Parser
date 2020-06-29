package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerBlockPlaceParser extends AbstractPacketParser implements PacketParser {

    public PlayerBlockPlaceParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2C", "PlayerBlockPlaceParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
