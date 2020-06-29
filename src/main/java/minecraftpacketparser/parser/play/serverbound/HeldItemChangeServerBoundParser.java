package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class HeldItemChangeServerBoundParser extends AbstractPacketParser implements PacketParser {

    public HeldItemChangeServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x23", "HeldItemChangeServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Held Item Change Server Bound");
        return result;
    }
}
