package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TagsParser extends AbstractPacketParser implements PacketParser {

    public TagsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x5C", "TagsParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Tags");
        return result;
    }
}
