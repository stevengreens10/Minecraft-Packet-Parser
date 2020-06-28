package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class RecipeBookDataParser extends AbstractPacketParser implements PacketParser {

    public RecipeBookDataParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x1D", "RecipeBookDataParser");
    }

    @Override
    public ParseResult parse(InputStream data, PrintStream output) throws IOException {
        super.parse(data, output);
        return null;
    }
}
