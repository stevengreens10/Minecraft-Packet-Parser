package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UpdateViewDistanceParser extends AbstractPacketParser implements PacketParser {

    public UpdateViewDistanceParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x41", "UpdateViewDistanceParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update View Distance");
        return result;
    }
}
