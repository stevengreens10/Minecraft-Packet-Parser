package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PlayDisconnectParser extends AbstractPacketParser implements PacketParser {

    public PlayDisconnectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1B", "PlayDisconnectParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Play Disconnect");
        return result;
    }
}
