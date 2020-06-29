package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class DeclareRecipesParser extends AbstractPacketParser implements PacketParser {

    public DeclareRecipesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x5B", "DeclareRecipesParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Declare Recipes");
        return result;
    }
}
