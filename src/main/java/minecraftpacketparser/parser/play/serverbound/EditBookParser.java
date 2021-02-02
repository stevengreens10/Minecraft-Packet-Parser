package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class EditBookParser extends AbstractPacketParser implements PacketParser {

    public EditBookParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x0C", "EditBookParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Edit Book");
        return result;
    }
}
