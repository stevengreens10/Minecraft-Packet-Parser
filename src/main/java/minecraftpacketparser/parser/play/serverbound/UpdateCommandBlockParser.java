package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateCommandBlockParser extends AbstractPacketParser implements PacketParser {

    public UpdateCommandBlockParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x24", "UpdateCommandBlockParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Update Command Block");
        return result;
    }
}
