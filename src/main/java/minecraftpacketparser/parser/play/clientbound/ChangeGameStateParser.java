package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ChangeGameStateParser extends AbstractPacketParser implements PacketParser {

    public ChangeGameStateParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1D", "ChangeGameStateParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Change Game State");
        return result;
    }
}
