package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetPassengersParser extends AbstractPacketParser implements PacketParser {

    public SetPassengersParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4B", "SetPassengersParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Passengers");
        return result;
    }
}
