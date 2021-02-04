package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UseItemParser extends AbstractPacketParser implements PacketParser {

    public UseItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2F", "UseItemParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Use Item");
        return result;
    }
}
