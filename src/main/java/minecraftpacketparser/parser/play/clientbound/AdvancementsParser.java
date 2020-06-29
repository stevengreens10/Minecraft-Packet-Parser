package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class AdvancementsParser extends AbstractPacketParser implements PacketParser {

    public AdvancementsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x58", "AdvancementsParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Advancements");
        return result;
    }
}
