package minecraftpacketparser.parser.play.serverbound;

import minecraftpacketparser.parser.*;
import minecraftpacketparser.proxy.Serializer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ChatMessageServerBoundParser extends AbstractPacketParser implements PacketParser {

    public ChatMessageServerBoundParser(){
        super(State.PLAY, Direction.SERVERBOUND, "0x03", "ChatMessageServerBoundParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Chat Message");
        result.output = new ByteArrayOutputStream();

        Serializer.writeVarInt(3, result.output);

        String message = Parser.parseString(data);
        result.packetFields.put("Chat message", message);

        message += ":)";
        Serializer.writeString(message, result.output);

        return result;
    }
}
