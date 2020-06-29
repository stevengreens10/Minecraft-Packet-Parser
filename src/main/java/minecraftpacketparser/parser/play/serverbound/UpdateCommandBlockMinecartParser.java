package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class UpdateCommandBlockMinecartParser extends AbstractPacketParser implements PacketParser {

    public UpdateCommandBlockMinecartParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x25", "UpdateCommandBlockMinecartParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Update Command Block Minecart");
        return result;
    }
}
