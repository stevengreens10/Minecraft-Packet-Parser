package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SelectTradeParser extends AbstractPacketParser implements PacketParser {

    public SelectTradeParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x21", "SelectTradeParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Select Trade");
        return result;
    }
}
