package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PlayerPositionParser extends AbstractPacketParser implements PacketParser {

    public PlayerPositionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x12", "PlayerPositionParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Position");
        return result;
    }
}
