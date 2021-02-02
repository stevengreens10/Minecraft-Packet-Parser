package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateSignParser extends AbstractPacketParser implements PacketParser {

    public UpdateSignParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2B", "UpdateSignParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Sign");
        return result;
    }
}
