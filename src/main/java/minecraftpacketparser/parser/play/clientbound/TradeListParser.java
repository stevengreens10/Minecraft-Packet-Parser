package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TradeListParser extends AbstractPacketParser implements PacketParser {

    public TradeListParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x28", "TradeListParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
