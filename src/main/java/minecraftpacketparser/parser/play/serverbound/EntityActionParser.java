package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EntityActionParser extends AbstractPacketParser implements PacketParser {

    public EntityActionParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1B", "EntityActionParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
