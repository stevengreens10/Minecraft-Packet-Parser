package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TeleportConfirmParser extends AbstractPacketParser implements PacketParser {

    public TeleportConfirmParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x00", "TeleportConfirmParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
