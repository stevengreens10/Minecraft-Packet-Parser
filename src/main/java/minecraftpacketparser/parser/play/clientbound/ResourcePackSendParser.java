package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ResourcePackSendParser extends AbstractPacketParser implements PacketParser {

    public ResourcePackSendParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3A", "ResourcePackSendParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
