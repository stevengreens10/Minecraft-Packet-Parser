package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class WindowConfirmationServerBoundParser extends AbstractPacketParser implements PacketParser {

    public WindowConfirmationServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x07", "WindowConfirmationServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Window Confirmation Server Bound");
        return result;
    }
}
