package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SetDisplayedRecipeParser extends AbstractPacketParser implements PacketParser {

    public SetDisplayedRecipeParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1F", "SetDisplayedRecipeParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Displayed Recipe State");
        return result;
    }
}
