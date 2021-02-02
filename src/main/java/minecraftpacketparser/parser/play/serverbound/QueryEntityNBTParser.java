package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class QueryEntityNBTParser extends AbstractPacketParser implements PacketParser {

    public QueryEntityNBTParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0D", "QueryEntityNBTParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Query Entity NBT");
        return result;
    }
}
