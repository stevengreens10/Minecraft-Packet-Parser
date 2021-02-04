package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class NameItemParser extends AbstractPacketParser implements PacketParser {

    public NameItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x20", "NameItemParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Name Item");
        return result;
    }
}
