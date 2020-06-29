package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class ResourcePackStatusParser extends AbstractPacketParser implements PacketParser {

    public ResourcePackStatusParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1F", "ResourcePackStatusParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
