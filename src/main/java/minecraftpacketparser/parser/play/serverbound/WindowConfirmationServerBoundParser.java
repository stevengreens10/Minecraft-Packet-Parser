package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class WindowConfirmationServerBoundParser extends AbstractPacketParser implements PacketParser {

    public WindowConfirmationServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x07", "WindowConfirmationServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Window Confirmation Server Bound");
        return result;
    }
}
