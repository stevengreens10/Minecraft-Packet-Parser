package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerPosAndLookServerBoundParser extends AbstractPacketParser implements PacketParser {

    public PlayerPosAndLookServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x12", "PlayerPosAndLookServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
