package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class MultiBlockChangeParser extends AbstractPacketParser implements PacketParser {

    public MultiBlockChangeParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x10", "MultiBlockChangeParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
