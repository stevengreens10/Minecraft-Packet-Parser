package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CreativeInventoryActionParser extends AbstractPacketParser implements PacketParser {

    public CreativeInventoryActionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x26", "CreativeInventoryActionParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Creative Inventory Action");
        return result;
    }
}
