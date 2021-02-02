package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CraftRecipeResponseParser extends AbstractPacketParser implements PacketParser {

    public CraftRecipeResponseParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x2F", "CraftRecipeResponseParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Craft Recipe Response");
        return result;
    }
}
