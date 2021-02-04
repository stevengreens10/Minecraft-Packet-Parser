package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CollectItemParser extends AbstractPacketParser implements PacketParser {

    public CollectItemParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x55", "CollectItemParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Collect Item");
        return result;
    }
}
