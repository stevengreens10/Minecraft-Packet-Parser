package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ResourcePackStatusParser extends AbstractPacketParser implements PacketParser {

    public ResourcePackStatusParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x21", "ResourcePackStatusParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Resource Pack Status");
        return result;
    }
}
