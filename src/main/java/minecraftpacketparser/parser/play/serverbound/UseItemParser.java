package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UseItemParser extends AbstractPacketParser implements PacketParser {

    public UseItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2F", "UseItemParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Use Item");
        return result;
    }
}
