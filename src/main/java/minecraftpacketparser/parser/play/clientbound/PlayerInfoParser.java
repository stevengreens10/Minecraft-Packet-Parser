package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class PlayerInfoParser extends AbstractPacketParser implements PacketParser {

    public PlayerInfoParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x32", "PlayerInfoParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Player Info");
        int action = Parser.parseVarInt(data);
        result.packetFields.put("Action", action);
        int numPlayers = Parser.parseVarInt(data);
        result.packetFields.put("Num Players", numPlayers);

        for(int i = 0; i < numPlayers; i++) {
            result.packetFields.put("\tPlayer[" + i + "] UUID", Parser.parseUUID(data));

            if(action == 0) {
                result.packetFields.put("\tPlayer[" + i + "] Name", Parser.parseString(data));
                Integer numProperties = Parser.parseVarInt(data);
                result.packetFields.put("\tPlayer[" + i + "] Num Properties", numProperties);

                for(int j = 0; j < numProperties; j++) {
                    result.packetFields.put("\t\tPlayer[" + i + "] Property Name [" + j + "]", Parser.parseString(data));
                    result.packetFields.put("\t\tPlayer[" + i + "] Property Value [" + j + "]", Parser.parseString(data));
                    Boolean signed = Parser.parseBoolean(data);
                    result.packetFields.put("\t\tPlayer[" + i + "] Property Is Signed? [" + j + "]", signed);
                    if(signed) {
                        result.packetFields.put("\t\tPlayer[" + i + "] Property Signature [" + j + "]", Parser.parseString(data));
                    }
                }
                result.packetFields.put("\tPlayer[" + i + "] Gamemode", Parser.parseVarInt(data));
                result.packetFields.put("\tPlayer[" + i + "] Ping", Parser.parseVarInt(data));
                Boolean hasDisplayName = Parser.parseBoolean(data);
                result.packetFields.put("\tPlayer[" + i + "] Has Display Name?", hasDisplayName);
                if(hasDisplayName) {
                    result.packetFields.put("\tPlayer[" + i + "] Display Name", Parser.parseChat(data));
                }
            } else if(action == 1) {
                result.packetFields.put("\tUpdate Player[" + i + "] Gamemode", Parser.parseVarInt(data));
            } else if(action == 2) {
                result.packetFields.put("\tUpdate Player[" + i + "] Ping", Parser.parseVarInt(data));
            } else if(action == 3) {
                Boolean hasDisplayName = Parser.parseBoolean(data);
                result.packetFields.put("\tPlayer[" + i + "] Has Display Name?", hasDisplayName);
                if (hasDisplayName) {
                    result.packetFields.put("\tUpdate Player[" + i + "] Display Name", Parser.parseChat(data));
                }
            }

        }

        return result;
    }
}
