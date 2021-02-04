package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class RecipeBookDataParser extends AbstractPacketParser implements PacketParser {

    public RecipeBookDataParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1D", "RecipeBookDataParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Recipe Book Data");
        return result;
    }
}
