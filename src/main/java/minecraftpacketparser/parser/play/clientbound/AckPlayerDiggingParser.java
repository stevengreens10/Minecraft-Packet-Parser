package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class AckPlayerDiggingParser extends AbstractPacketParser implements PacketParser {

    public AckPlayerDiggingParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x07", "AckPlayerDiggingParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        ParseResult result = new ParseResult("Acknowledge Player Digging");
        result.packetFields.put("Location", Parser.parsePosition(data));
        result.packetFields.put("Block State", Parser.parseVarInt(data));

        int status = Parser.parseVarInt(data);
        String statusStr = "INVALID";
        switch (status) {
            case 0:
                statusStr = "Digging";
                break;
            case 1:
                statusStr = "Stopped Digging";
                break;
            case 2:
                statusStr = "Finished Digging";
        }

        result.packetFields.put("Status", statusStr);
        result.packetFields.put("Successful?", Parser.parseBoolean(data));
        return result;
    }
}
