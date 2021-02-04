package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ResourcePackSendParser extends AbstractPacketParser implements PacketParser {

    public ResourcePackSendParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x38", "ResourcePackSendParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Resource Pack Send");
        return result;
    }
}
