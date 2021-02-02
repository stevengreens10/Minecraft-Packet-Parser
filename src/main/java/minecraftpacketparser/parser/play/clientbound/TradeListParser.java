package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TradeListParser extends AbstractPacketParser implements PacketParser {

    public TradeListParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x26", "TradeListParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Trade List");
        return result;
    }
}
