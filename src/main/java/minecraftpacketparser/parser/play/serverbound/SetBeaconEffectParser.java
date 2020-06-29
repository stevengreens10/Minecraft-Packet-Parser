package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class SetBeaconEffectParser extends AbstractPacketParser implements PacketParser {

    public SetBeaconEffectParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x22", "SetBeaconEffectParser");
    }

    @Override
    public ParseResult parse(InputStream data) throws IOException {
        super.parse(data);
        return null;
    }
}
