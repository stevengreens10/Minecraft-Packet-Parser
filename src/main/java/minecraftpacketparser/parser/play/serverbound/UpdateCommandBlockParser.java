package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateCommandBlockParser extends AbstractPacketParser implements PacketParser {

    public UpdateCommandBlockParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x26", "UpdateCommandBlockParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Command Block");
        return result;
    }
}
