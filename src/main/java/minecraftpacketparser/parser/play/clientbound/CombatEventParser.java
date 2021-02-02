package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CombatEventParser extends AbstractPacketParser implements PacketParser {

    public CombatEventParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x31", "CombatEventParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Combat Event");
        return result;
    }
}
