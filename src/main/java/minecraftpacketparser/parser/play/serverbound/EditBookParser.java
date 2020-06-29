package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EditBookParser extends AbstractPacketParser implements PacketParser {

    public EditBookParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0C", "EditBookParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
