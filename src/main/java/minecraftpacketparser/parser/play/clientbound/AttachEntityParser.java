package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class AttachEntityParser extends AbstractPacketParser implements PacketParser {

    public AttachEntityParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x45", "AttachEntityParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Attach Entity");
        return result;
    }
}
