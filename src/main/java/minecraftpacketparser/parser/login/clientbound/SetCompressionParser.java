package minecraftpacketparser.parser.login.clientbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class SetCompressionParser extends AbstractPacketParser implements PacketParser {

    public SetCompressionParser(){
        super(State.LOGIN, Direction.CLIENTBOUND, "0x03", "SetCompressionParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
