package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerPositionParser extends AbstractPacketParser implements PacketParser {

    public PlayerPositionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x11", "PlayerPositionParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Player Position");
        return result;
    }
}
