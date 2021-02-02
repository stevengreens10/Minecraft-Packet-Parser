package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TagsParser extends AbstractPacketParser implements PacketParser {

    public TagsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x5B", "TagsParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Tags");
        return result;
    }
}
