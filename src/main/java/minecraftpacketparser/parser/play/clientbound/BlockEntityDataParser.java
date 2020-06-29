package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class BlockEntityDataParser extends AbstractPacketParser implements PacketParser {

    public BlockEntityDataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x0A", "BlockEntityDataParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
