package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CloseWindowClientBoundParser extends AbstractPacketParser implements PacketParser {

    public CloseWindowClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x14", "CloseWindowClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
