package minecraftpacketparser.parser.handshake.serverbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class StartHandshakeParser extends AbstractPacketParser implements PacketParser {

    public StartHandshakeParser() {
        super(State.HANDSHAKE, Direction.SERVERBOUND, "0x00", "StartHandshakeParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
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

        result.output = new ByteArrayOutputStream();
        byte[] response = {0x00, (byte) 0xf2, 0x05, 0x0b, 0x31, 0x39, 0x32, 0x2e, 0x31, 0x36, 0x38, 0x2e, 0x30, 0x2e, 0x34, 0x63, (byte) 0xdd, 0x01};
        if(nextState == 2) {
            response[response.length-1] = 0x2;
        }
        result.output.write(response);

        return result;
    }
}
