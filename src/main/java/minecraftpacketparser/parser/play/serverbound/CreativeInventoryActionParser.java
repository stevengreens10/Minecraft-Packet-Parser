package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CreativeInventoryActionParser extends AbstractPacketParser implements PacketParser {

    public CreativeInventoryActionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x28", "CreativeInventoryActionParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Creative Inventory Action");
        return result;
    }
}
