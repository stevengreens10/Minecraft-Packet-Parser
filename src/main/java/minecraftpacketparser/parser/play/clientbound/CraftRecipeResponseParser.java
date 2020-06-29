package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CraftRecipeResponseParser extends AbstractPacketParser implements PacketParser {

    public CraftRecipeResponseParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x31", "CraftRecipeResponseParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Craft Recipe Response");
        return result;
    }
}
