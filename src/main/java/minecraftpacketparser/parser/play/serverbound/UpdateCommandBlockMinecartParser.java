package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateCommandBlockMinecartParser extends AbstractPacketParser implements PacketParser {

    public UpdateCommandBlockMinecartParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x27", "UpdateCommandBlockMinecartParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Command Block Minecart");
        return result;
    }
}
