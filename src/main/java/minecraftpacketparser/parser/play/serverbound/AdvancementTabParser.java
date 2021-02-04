package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class AdvancementTabParser extends AbstractPacketParser implements PacketParser {

    public AdvancementTabParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x22", "AdvancementTabParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Advancement Tab");
        return result;
    }
}
