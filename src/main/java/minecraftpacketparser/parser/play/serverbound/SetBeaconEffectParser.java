package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class SetBeaconEffectParser extends AbstractPacketParser implements PacketParser {

    public SetBeaconEffectParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x24", "SetBeaconEffectParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Set Beacon Effect");
        return result;
    }
}
