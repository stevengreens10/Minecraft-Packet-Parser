package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DestroyEntitiesParser extends AbstractPacketParser implements PacketParser {

    public DestroyEntitiesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x36", "DestroyEntitiesParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Destroy Entities");
        return result;
    }
}
