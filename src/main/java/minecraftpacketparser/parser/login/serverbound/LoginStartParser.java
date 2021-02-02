package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LoginStartParser extends AbstractPacketParser implements PacketParser {

    public LoginStartParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x00", "LoginStartParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Login Start");
        result.packetFields.put("Username", Parser.parseString(data));
        return result;
    }
}
