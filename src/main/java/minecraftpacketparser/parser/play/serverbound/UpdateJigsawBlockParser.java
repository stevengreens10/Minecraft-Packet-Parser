package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateJigsawBlockParser extends AbstractPacketParser implements PacketParser {

    public UpdateJigsawBlockParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x27", "UpdateJigsawBlockParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
