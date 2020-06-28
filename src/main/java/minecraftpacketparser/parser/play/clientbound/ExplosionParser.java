package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ExplosionParser extends AbstractPacketParser implements PacketParser {

    public ExplosionParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x1D", "ExplosionParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
