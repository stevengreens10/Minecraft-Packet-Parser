package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ClientSettingsParser extends AbstractPacketParser implements PacketParser {

    public ClientSettingsParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x05", "ClientSettingsParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Client Settings");
        return result;
    }
}
