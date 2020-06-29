package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class NameItemParser extends AbstractPacketParser implements PacketParser {

    public NameItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1E", "NameItemParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
