package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TimeUpdateParser extends AbstractPacketParser implements PacketParser {

    public TimeUpdateParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x4F", "TimeUpdateParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
