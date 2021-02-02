package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class FacePlayerParser extends AbstractPacketParser implements PacketParser {

    public FacePlayerParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x33", "FacePlayerParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Face Player");
        return result;
    }
}
