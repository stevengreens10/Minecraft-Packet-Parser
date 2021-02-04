package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class UnlockRecipesParser extends AbstractPacketParser implements PacketParser {

    public UnlockRecipesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x35", "UnlockRecipesParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Unlock Recipes");
        Integer action = Parser.parseVarInt(data);
        result.packetFields.put("Action", action);
        result.packetFields.put("Crafting Recipe Book Open?", Parser.parseBoolean(data));
        result.packetFields.put("Crafting Recipe Book Filter Active?", Parser.parseBoolean(data));
        result.packetFields.put("Smelting Recipe Book Open?", Parser.parseBoolean(data));
        result.packetFields.put("Smelting Recipe Book Filter Active?", Parser.parseBoolean(data));
        result.packetFields.put("Blast Furance Recipe Book Open?", Parser.parseBoolean(data));
        result.packetFields.put("Blast Furance Recipe Book Filter Active?", Parser.parseBoolean(data));
        result.packetFields.put("Smoker Recipe Book Open?", Parser.parseBoolean(data));
        result.packetFields.put("Smoker Recipe Book Filter Active?", Parser.parseBoolean(data));
        Integer arraySize1 = Parser.parseVarInt(data);
        result.packetFields.put("Array Size 1", arraySize1);
        for(int i = 0; i < arraySize1; i++) {
            result.packetFields.put("\tRecipe ID Arr1 [" + i + "]", Parser.parseIdentifier(data));
        }

        if(action == 0) {
            Integer arraySize2 = Parser.parseVarInt(data);
            result.packetFields.put("Array Size 2", arraySize2);
            for (int i = 0; i < arraySize2; i++) {
                result.packetFields.put("\tRecipe ID Arr2 [" + i + "]", Parser.parseIdentifier(data));
            }
        }

        return result;
    }
}
