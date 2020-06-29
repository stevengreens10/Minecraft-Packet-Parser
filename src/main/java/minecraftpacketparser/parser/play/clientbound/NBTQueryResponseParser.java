package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class NBTQueryResponseParser extends AbstractPacketParser implements PacketParser {

    public NBTQueryResponseParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x55", "NBTQueryResponseParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
