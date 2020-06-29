package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class RemoveEntityEffect extends AbstractPacketParser implements PacketParser {

    public RemoveEntityEffect(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x39", "RemoveEntityEffect");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
