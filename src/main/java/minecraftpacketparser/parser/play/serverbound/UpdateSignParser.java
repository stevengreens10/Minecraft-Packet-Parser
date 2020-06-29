package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateSignParser extends AbstractPacketParser implements PacketParser {

    public UpdateSignParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x29", "UpdateSignParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
