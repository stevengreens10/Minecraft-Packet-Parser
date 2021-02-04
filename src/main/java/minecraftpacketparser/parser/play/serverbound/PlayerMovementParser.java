package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PlayerMovementParser extends AbstractPacketParser implements PacketParser {

    public PlayerMovementParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x15", "PlayerMovementParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Movement");
        return result;
    }
}
