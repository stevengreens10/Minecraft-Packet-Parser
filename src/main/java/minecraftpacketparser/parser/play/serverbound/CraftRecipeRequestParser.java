package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CraftRecipeRequestParser extends AbstractPacketParser implements PacketParser {

    public CraftRecipeRequestParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x18", "CraftRecipeRequestParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
