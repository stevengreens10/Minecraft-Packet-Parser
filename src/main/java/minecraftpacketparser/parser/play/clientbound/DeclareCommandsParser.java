package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class DeclareCommandsParser extends AbstractPacketParser implements PacketParser {

    public DeclareCommandsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x10", "DeclareCommandsParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Declare Commands");
        return result;
    }
}
