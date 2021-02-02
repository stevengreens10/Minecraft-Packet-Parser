package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetCooldownParser extends AbstractPacketParser implements PacketParser {

    public SetCooldownParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x16", "SetCooldownParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Cooldown");
        return result;
    }
}
