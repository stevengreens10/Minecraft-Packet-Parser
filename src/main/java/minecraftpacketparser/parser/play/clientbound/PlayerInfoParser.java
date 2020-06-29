package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class PlayerInfoParser extends AbstractPacketParser implements PacketParser {

    public PlayerInfoParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x34", "PlayerInfoParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Player Info");
        return result;
    }
}
