package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UpdateStructureBlockParser extends AbstractPacketParser implements PacketParser {

    public UpdateStructureBlockParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2A", "UpdateStructureBlockParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Structure Block");
        return result;
    }
}
