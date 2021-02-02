package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class OpenBookParser extends AbstractPacketParser implements PacketParser {

    public OpenBookParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2C", "OpenBookParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Open Book");
        return result;
    }
}
