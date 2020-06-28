package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EntityPropertiesParser extends AbstractPacketParser implements PacketParser {

    public EntityPropertiesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x59", "EntityPropertiesParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
