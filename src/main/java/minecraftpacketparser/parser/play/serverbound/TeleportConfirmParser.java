package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class TeleportConfirmParser extends AbstractPacketParser implements PacketParser {

    public TeleportConfirmParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x00", "TeleportConfirmParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Teleport Confirm");
        return result;
    }
}
