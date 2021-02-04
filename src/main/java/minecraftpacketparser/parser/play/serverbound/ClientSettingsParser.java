package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class ClientSettingsParser extends AbstractPacketParser implements PacketParser {

    public ClientSettingsParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x05", "ClientSettingsParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Client Settings");
        return result;
    }
}
