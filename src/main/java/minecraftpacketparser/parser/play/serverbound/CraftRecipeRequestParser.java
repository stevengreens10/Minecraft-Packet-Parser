package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class CraftRecipeRequestParser extends AbstractPacketParser implements PacketParser {

    public CraftRecipeRequestParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x19", "CraftRecipeRequestParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Craft Recipe Request");
        return result;
    }
}
