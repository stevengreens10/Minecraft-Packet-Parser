package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetCompressionParser extends AbstractPacketParser implements PacketParser {

    public SetCompressionParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x03", "SetCompressionParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Compression");
        return result;
    }
}
