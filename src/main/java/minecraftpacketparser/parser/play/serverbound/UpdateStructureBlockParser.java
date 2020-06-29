package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateStructureBlockParser extends AbstractPacketParser implements PacketParser {

    public UpdateStructureBlockParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x28", "UpdateStructureBlockParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Update Structure Block");
        return result;
    }
}
