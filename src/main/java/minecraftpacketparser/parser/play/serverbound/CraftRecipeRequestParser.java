package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class CraftRecipeRequestParser extends AbstractPacketParser implements PacketParser {

    public CraftRecipeRequestParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x19", "CraftRecipeRequestParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Craft Recipe Request");
        return result;
    }
}
