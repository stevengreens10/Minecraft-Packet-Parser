package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class CameraParser extends AbstractPacketParser implements PacketParser {

    public CameraParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x3F", "CameraParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
