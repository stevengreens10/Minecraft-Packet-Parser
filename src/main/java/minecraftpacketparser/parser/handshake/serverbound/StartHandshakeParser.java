package minecraftpacketparser.parser.handshake.serverbound;

import minecraftpacketparser.parser.*;

import java.io.IOException;
import java.io.InputStream;

public class StartHandshakeParser extends AbstractPacketParser implements PacketParser {

    public StartHandshakeParser() {
        super(State.HANDSHAKE, Direction.SERVERBOUND, "0x00", "StartHandshakeParser");
    }

    @Override
    public ParseResult parse(Parser parser, InputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("StartHandshake");
        result.packetFields.put("Protocol Version", Parser.parseVarInt(data));
        result.packetFields.put("Server Address", Parser.parseString(data));
        result.packetFields.put("Server Port", Parser.parseUnsignedShort(data));
        int nextState = Parser.parseVarInt(data);
        switch(nextState) {
            case 1:
                result.packetFields.put("Next State", "Status");
                parser.state = State.STATUS;
                break;
            case 2:
                result.packetFields.put("Next State", "Login");
                parser.state = State.LOGIN;
                break;
            default:
                result.packetFields.put("Next State", "Unknown");

        }
        return result;
    }
}
