package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class WindowConfirmationClientBoundParser extends AbstractPacketParser implements PacketParser {

    public WindowConfirmationClientBoundParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x11", "WindowConfirmationClientBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Window Confirmation Client Bound");
        return result;
    }
}
