package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class BlockBreakAnimParser extends AbstractPacketParser implements PacketParser {

    public BlockBreakAnimParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x09", "BlockBreakAnimParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
