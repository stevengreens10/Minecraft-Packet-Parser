package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerRotationParser extends AbstractPacketParser implements PacketParser {

    public PlayerRotationParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x14", "PlayerRotationParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Rotation");
        return result;
    }
}
