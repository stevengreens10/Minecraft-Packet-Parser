package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CloseWindowServerBoundParser extends AbstractPacketParser implements PacketParser {

    public CloseWindowServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0A", "CloseWindowServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Close Window Server Bound");
        return result;
    }
}
