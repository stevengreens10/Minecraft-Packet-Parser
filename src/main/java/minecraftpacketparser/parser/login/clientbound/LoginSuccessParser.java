package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LoginSuccessParser extends AbstractPacketParser implements PacketParser {

    public LoginSuccessParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x02", "LoginSuccessParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Login Success");
        result.packetFields.put("UUID", Parser.parseUUID(data));
        result.packetFields.put("Username", Parser.parseString(data));
        parser.state = State.PLAY;
        return result;
    }
}
