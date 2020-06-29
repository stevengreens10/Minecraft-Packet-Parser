package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UseItemParser extends AbstractPacketParser implements PacketParser {

    public UseItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2D", "UseItemParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Use Item");
        return result;
    }
}
