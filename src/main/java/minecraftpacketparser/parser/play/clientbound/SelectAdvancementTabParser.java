package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SelectAdvancementTabParser extends AbstractPacketParser implements PacketParser {

    public SelectAdvancementTabParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3D", "SelectAdvancementTabParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Select Advancement Tab");
        return result;
    }
}
