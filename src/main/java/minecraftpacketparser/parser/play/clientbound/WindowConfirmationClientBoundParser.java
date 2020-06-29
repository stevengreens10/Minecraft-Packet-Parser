package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class WindowConfirmationClientBoundParser extends AbstractPacketParser implements PacketParser {

    public WindowConfirmationClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x13", "WindowConfirmationClientBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Window Confirmation Client Bound");
        return result;
    }
}
