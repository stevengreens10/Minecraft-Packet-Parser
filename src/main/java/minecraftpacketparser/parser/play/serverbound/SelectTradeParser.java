package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SelectTradeParser extends AbstractPacketParser implements PacketParser {

    public SelectTradeParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x23", "SelectTradeParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Select Trade");
        return result;
    }
}
