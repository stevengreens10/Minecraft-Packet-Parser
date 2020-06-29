package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class DeclareCommandsParser extends AbstractPacketParser implements PacketParser {

    public DeclareCommandsParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x12", "DeclareCommandsParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Declare Commands");
        return result;
    }
}
