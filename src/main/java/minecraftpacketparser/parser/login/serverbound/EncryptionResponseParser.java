package minecraftpacketparser.parser.login.serverbound;

import minecraftpacketparser.parser.AbstractPacketParser;
import minecraftpacketparser.parser.Direction;
import minecraftpacketparser.parser.PacketParser;
import minecraftpacketparser.parser.State;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class EncryptionResponseParser extends AbstractPacketParser implements PacketParser {

    public EncryptionResponseParser(){
        super(State.LOGIN, Direction.SERVERBOUND, "0x01", "EncryptionResponseParser");
    }

    @Override
    public void parse(InputStream data, PrintStream output) throws IOException {
		super.parse(data, output);
    }
}
