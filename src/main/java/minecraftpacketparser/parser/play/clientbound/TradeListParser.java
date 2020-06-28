package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TradeListParser extends AbstractPacketParser implements PacketParser {

    public TradeListParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x28", "TradeListParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
