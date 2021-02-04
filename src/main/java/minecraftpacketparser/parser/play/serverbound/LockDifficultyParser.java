package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class LockDifficultyParser extends AbstractPacketParser implements PacketParser {

    public LockDifficultyParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x11", "LockDifficultyParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Lock Difficulty");
        return result;
    }
}
