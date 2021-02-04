package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class QueryBlockNBTParser extends AbstractPacketParser implements PacketParser {

    public QueryBlockNBTParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x01", "QueryBlockNBTParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Query Block NBT");
        return result;
    }
}
