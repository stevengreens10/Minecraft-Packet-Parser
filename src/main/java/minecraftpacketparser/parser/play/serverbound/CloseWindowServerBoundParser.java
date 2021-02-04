package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CloseWindowServerBoundParser extends AbstractPacketParser implements PacketParser {

    public CloseWindowServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0A", "CloseWindowServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Close Window Server Bound");
        return result;
    }
}
