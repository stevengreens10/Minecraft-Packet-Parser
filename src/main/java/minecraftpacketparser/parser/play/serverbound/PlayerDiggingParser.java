package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerDiggingParser extends AbstractPacketParser implements PacketParser {

    public PlayerDiggingParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1B", "PlayerDiggingParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Digging");
        return result;
    }
}
