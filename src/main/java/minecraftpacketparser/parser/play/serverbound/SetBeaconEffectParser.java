package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetBeaconEffectParser extends AbstractPacketParser implements PacketParser {

    public SetBeaconEffectParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x24", "SetBeaconEffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Beacon Effect");
        return result;
    }
}
