package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class NameItemParser extends AbstractPacketParser implements PacketParser {

    public NameItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x20", "NameItemParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Name Item");
        return result;
    }
}
