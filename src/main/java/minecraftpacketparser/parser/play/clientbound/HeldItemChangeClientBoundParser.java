package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class HeldItemChangeClientBoundParser extends AbstractPacketParser implements PacketParser {

    public HeldItemChangeClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x40", "HeldItemChangeClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Held Item Change Client Bound");
        return result;
    }
}
