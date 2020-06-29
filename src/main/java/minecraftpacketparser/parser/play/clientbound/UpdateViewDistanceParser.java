package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateViewDistanceParser extends AbstractPacketParser implements PacketParser {

    public UpdateViewDistanceParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x42", "UpdateViewDistanceParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Update View Distance");
        return result;
    }
}
