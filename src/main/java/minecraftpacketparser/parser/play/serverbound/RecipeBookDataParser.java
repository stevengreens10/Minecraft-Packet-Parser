package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class RecipeBookDataParser extends AbstractPacketParser implements PacketParser {

    public RecipeBookDataParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1D", "RecipeBookDataParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
