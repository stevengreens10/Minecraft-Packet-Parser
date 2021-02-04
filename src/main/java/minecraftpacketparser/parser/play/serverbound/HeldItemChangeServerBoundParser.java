package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class HeldItemChangeServerBoundParser extends AbstractPacketParser implements PacketParser {

    public HeldItemChangeServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x25", "HeldItemChangeServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Held Item Change Server Bound");
        return result;
    }
}
