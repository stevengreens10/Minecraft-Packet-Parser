package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetDisplayedRecipeParser extends AbstractPacketParser implements PacketParser {

    public SetDisplayedRecipeParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1F", "SetDisplayedRecipeParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Displayed Recipe State");
        return result;
    }
}
