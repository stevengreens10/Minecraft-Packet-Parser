package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PickItemParser extends AbstractPacketParser implements PacketParser {

    public PickItemParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x17", "PickItemParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Pick Item");
        return result;
    }
}
