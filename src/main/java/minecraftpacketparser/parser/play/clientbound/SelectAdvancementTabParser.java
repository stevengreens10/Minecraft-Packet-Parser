package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SelectAdvancementTabParser extends AbstractPacketParser implements PacketParser {

    public SelectAdvancementTabParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3C", "SelectAdvancementTabParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Select Advancement Tab");
        return result;
    }
}
