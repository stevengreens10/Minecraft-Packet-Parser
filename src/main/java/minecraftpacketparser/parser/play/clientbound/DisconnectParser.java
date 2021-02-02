package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class DisconnectParser extends AbstractPacketParser implements PacketParser {

    public DisconnectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x19", "DisconnectParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Disconnect");
        return result;
    }
}