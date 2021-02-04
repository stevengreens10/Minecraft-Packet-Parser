package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class BossBarParser extends AbstractPacketParser implements PacketParser {

    public BossBarParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0C", "BossBarParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Boss Bar");
        return result;
    }
}
