package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class AdvancementTabParser extends AbstractPacketParser implements PacketParser {

    public AdvancementTabParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x20", "AdvancementTabParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
