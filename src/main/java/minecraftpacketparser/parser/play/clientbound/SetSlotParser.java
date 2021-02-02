package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetSlotParser extends AbstractPacketParser implements PacketParser {

    public SetSlotParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x15", "SetSlotParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Slot");
        return result;
    }
}
