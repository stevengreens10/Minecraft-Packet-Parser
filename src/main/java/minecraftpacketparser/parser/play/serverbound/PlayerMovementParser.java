package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerMovementParser extends AbstractPacketParser implements PacketParser {

    public PlayerMovementParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x14", "PlayerMovementParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Player Movement");
        return result;
    }
}
