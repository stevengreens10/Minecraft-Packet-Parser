package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateStructureBlockParser extends AbstractPacketParser implements PacketParser {

    public UpdateStructureBlockParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2A", "UpdateStructureBlockParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Structure Block");
        return result;
    }
}
