package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class InteractEntityParser extends AbstractPacketParser implements PacketParser {

    public InteractEntityParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0E", "InteractEntityParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Interact Entity");
        return result;
    }
}
