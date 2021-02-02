package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateViewDistanceParser extends AbstractPacketParser implements PacketParser {

    public UpdateViewDistanceParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x41", "UpdateViewDistanceParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update View Distance");
        return result;
    }
}
