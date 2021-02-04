package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PlayerAbilitiesServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerAbilitiesServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1A", "PlayerAbilitiesServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Abilities Server Bound");
        return result;
    }
}
