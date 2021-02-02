package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateJigsawBlockParser extends AbstractPacketParser implements PacketParser {

    public UpdateJigsawBlockParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x29", "UpdateJigsawBlockParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Jigsaw Block");
        return result;
    }
}
