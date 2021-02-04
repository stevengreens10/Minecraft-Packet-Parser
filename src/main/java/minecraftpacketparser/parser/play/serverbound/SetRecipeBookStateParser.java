package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SetRecipeBookStateParser extends AbstractPacketParser implements PacketParser {

    public SetRecipeBookStateParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1E", "SetRecipeBookStateParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Recipe Book State");
        return result;
    }
}
