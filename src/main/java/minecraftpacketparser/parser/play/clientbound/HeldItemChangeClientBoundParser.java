package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class HeldItemChangeClientBoundParser extends AbstractPacketParser implements PacketParser {

    public HeldItemChangeClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3F", "HeldItemChangeClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Held Item Change Client Bound");
        result.packetFields.put("Slot", Parser.parseByte(data));
        return result;
    }
}
