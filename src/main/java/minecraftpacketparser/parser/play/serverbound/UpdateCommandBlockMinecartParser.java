package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UpdateCommandBlockMinecartParser extends AbstractPacketParser implements PacketParser {

    public UpdateCommandBlockMinecartParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x27", "UpdateCommandBlockMinecartParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Update Command Block Minecart");
        return result;
    }
}
