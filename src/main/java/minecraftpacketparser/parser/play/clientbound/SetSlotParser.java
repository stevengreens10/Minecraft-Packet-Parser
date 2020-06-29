package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetSlotParser extends AbstractPacketParser implements PacketParser {

    public SetSlotParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x17", "SetSlotParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Set Slot");
        return result;
    }
}
