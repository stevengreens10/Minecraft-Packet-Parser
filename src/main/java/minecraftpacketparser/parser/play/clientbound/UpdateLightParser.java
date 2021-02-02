package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateLightParser extends AbstractPacketParser implements PacketParser {

    public UpdateLightParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x23", "UpdateLightParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Light");
        return result;
    }
}
