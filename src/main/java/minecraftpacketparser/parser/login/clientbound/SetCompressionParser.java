package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SetCompressionParser extends AbstractPacketParser implements PacketParser {

    public SetCompressionParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x03", "SetCompressionParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Compression");
        return result;
    }
}
