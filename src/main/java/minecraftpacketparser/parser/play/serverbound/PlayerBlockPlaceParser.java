package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerBlockPlaceParser extends AbstractPacketParser implements PacketParser {

    public PlayerBlockPlaceParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2E", "PlayerBlockPlaceParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Block Place");
        return result;
    }
}
