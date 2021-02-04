package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CloseWindowClientBoundParser extends AbstractPacketParser implements PacketParser {

    public CloseWindowClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x12", "CloseWindowClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Close Window Client Bound");
        return result;
    }
}
