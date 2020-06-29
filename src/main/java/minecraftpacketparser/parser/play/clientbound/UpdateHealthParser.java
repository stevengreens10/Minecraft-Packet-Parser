package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateHealthParser extends AbstractPacketParser implements PacketParser {

    public UpdateHealthParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x49", "UpdateHealthParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Update Health");
        return result;
    }
}
