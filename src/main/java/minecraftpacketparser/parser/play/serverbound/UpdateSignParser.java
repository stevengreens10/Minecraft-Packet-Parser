package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UpdateSignParser extends AbstractPacketParser implements PacketParser {

    public UpdateSignParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2B", "UpdateSignParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Sign");
        return result;
    }
}
