package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class AnimationServerBoundParser extends AbstractPacketParser implements PacketParser {

    public AnimationServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x2A", "AnimationServerBoundParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        ParseResult result = new ParseResult("Animation Server Bound");
        return result;
    }
}
