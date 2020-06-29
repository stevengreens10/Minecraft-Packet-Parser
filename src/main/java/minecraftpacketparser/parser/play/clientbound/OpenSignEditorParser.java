package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class OpenSignEditorParser extends AbstractPacketParser implements PacketParser {

    public OpenSignEditorParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x30", "OpenSignEditorParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
