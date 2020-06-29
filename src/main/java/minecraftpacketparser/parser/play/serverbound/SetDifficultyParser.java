package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetDifficultyParser extends AbstractPacketParser implements PacketParser {

    public SetDifficultyParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x02", "SetDifficultyParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
