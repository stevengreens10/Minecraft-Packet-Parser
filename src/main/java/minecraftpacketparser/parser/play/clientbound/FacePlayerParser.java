package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class FacePlayerParser extends AbstractPacketParser implements PacketParser {

    public FacePlayerParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x35", "FacePlayerParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Face Player");
        return result;
    }
}
