package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class UpdateHealthParser extends AbstractPacketParser implements PacketParser {

    public UpdateHealthParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x49", "UpdateHealthParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
