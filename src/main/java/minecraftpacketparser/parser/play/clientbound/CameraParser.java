package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CameraParser extends AbstractPacketParser implements PacketParser {

    public CameraParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3F", "CameraParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Camera");
        return result;
    }
}
