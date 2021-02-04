package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class RemoveEntityEffect extends AbstractPacketParser implements PacketParser {

    public RemoveEntityEffect(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x37", "RemoveEntityEffect");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        return null;
    }
}
