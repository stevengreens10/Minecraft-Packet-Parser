package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class OpenBookParser extends AbstractPacketParser implements PacketParser {

    public OpenBookParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2C", "OpenBookParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Open Book");
        return result;
    }
}
