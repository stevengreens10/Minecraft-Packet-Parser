package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ClickWindowParser extends AbstractPacketParser implements PacketParser {

    public ClickWindowParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x09", "ClickWindowParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
