package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class QueryBlockNBTParser extends AbstractPacketParser implements PacketParser {

    public QueryBlockNBTParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x01", "QueryBlockNBTParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
