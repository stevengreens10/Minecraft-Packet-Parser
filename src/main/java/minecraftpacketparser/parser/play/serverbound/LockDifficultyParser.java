package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class LockDifficultyParser extends AbstractPacketParser implements PacketParser {

    public LockDifficultyParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x11", "LockDifficultyParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Lock Difficulty");
        return result;
    }
}
