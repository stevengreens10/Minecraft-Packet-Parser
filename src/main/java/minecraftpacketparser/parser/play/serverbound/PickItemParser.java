package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PickItemParser extends AbstractPacketParser implements PacketParser {

    public PickItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x18", "PickItemParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Pick Item");
        return result;
    }
}
