package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class ClientStatusParser extends AbstractPacketParser implements PacketParser {

    public ClientStatusParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x04", "ClientStatusParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    	return null;
	}
}
