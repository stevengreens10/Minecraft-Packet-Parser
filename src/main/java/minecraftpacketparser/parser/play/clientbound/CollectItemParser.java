package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CollectItemParser extends AbstractPacketParser implements PacketParser {

    public CollectItemParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x56", "CollectItemParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
