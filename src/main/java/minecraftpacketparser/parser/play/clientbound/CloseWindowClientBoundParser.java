package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CloseWindowClientBoundParser extends AbstractPacketParser implements PacketParser {

    public CloseWindowClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x12", "CloseWindowClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Close Window Client Bound");
        return result;
    }
}
