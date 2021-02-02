package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerAbilitiesServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerAbilitiesServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1A", "PlayerAbilitiesServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Abilities Server Bound");
        return result;
    }
}
