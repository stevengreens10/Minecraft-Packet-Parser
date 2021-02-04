package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DisconnectParser extends AbstractPacketParser implements PacketParser {

    public DisconnectParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x19", "DisconnectParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Disconnect");
        return result;
    }
}