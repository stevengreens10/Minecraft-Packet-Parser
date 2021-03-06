package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ResourcePackSendParser extends AbstractPacketParser implements PacketParser {

    public ResourcePackSendParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x38", "ResourcePackSendParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Resource Pack Send");
        return result;
    }
}
