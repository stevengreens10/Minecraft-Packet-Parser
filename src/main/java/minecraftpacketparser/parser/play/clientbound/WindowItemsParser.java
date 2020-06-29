package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;
import minecraftpacketparser.parser.datatype.Slot;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class WindowItemsParser extends AbstractPacketParser implements PacketParser {

    public WindowItemsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x15", "WindowItemsParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Inventory Items");
        result.packetFields.put("Window ID", Parser.parseUnsignedByte(data));

        Short count = Parser.parseShort(data);
        result.packetFields.put("Count", count);

        Slot[] slots = new Slot[count];
        for(int i = 0; i < count; i++) {
            slots[i] = Parser.parseSlot(data);
        }

        result.packetFields.put("Items", Arrays.deepToString(slots));

        return result;
    }
}
