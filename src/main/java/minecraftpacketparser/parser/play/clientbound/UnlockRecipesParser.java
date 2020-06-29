package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UnlockRecipesParser extends AbstractPacketParser implements PacketParser {

    public UnlockRecipesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x37", "UnlockRecipesParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Unlock Recipes");
        return result;
    }
}
