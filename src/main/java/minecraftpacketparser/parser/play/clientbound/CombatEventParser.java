package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CombatEventParser extends AbstractPacketParser implements PacketParser {

    public CombatEventParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x31", "CombatEventParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Combat Event");
        return result;
    }
}
