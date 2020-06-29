package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerPosAndLookClientBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerPosAndLookClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x36", "PlayerPosAndLookClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Player Position and Look");
        return result;
    }
}
