package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerPosAndLookServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerPosAndLookServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x13", "PlayerPosAndLookServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Position and Look");
        return result;
    }
}
