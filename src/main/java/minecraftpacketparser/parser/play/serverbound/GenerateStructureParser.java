package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class GenerateStructureParser extends AbstractPacketParser implements PacketParser {

    public GenerateStructureParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0F", "GenerateStructureParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Generate Structure");
        return null;
    }
}
