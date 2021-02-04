package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SetDifficultyParser extends AbstractPacketParser implements PacketParser {

    public SetDifficultyParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x02", "SetDifficultyParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Difficulty");
        return result;
    }
}
