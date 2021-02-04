package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class OpenSignEditorParser extends AbstractPacketParser implements PacketParser {

    public OpenSignEditorParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2E", "OpenSignEditorParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Open Sign Editor");
        return result;
    }
}
