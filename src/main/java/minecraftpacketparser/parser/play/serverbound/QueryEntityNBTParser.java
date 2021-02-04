package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class QueryEntityNBTParser extends AbstractPacketParser implements PacketParser {

    public QueryEntityNBTParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0D", "QueryEntityNBTParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Query Entity NBT");
        return result;
    }
}
