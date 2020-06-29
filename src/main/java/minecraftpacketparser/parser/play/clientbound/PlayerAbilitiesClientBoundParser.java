package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerAbilitiesClientBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerAbilitiesClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x32", "PlayerAbilitiesClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Player Abilities Client Bound");
        return result;
    }
}
