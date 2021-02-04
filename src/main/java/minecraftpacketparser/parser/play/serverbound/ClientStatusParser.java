package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ClientStatusParser extends AbstractPacketParser implements PacketParser {

    public ClientStatusParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x04", "ClientStatusParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Client Status");
        return result;
    }
}
