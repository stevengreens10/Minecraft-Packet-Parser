package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DeclareRecipesParser extends AbstractPacketParser implements PacketParser {

    public DeclareRecipesParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x5A", "DeclareRecipesParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Declare Recipes");
        int numRecipes = Parser.parseVarInt(data);
        result.packetFields.put("Number of Recipes", numRecipes);

        for(int i = 0; i < numRecipes; i++) {
            String recipeType = Parser.parseIdentifier(data);
            result.packetFields.put("\tRecipe[" + i + "] Type", recipeType);
            result.packetFields.put("\tRecipe[" + i + "] ID", Parser.parseIdentifier(data));

            switch(recipeType) {
                case "minecraft:crafting_shapeless":
                    result.packetFields.put("\tRecipe[" + i + "] Group", Parser.parseString(data));
                    Integer count = Parser.parseVarInt(data);
                    result.packetFields.put("\tRecipe[" + i + "] Ingredient Count", count);
                    for(int j = 0; j < count; j++) {
                        parseIngredient(result, "\t\tIngredient[" + j + "]" , data);
                    }
                    result.packetFields.put("\tRecipe[" + i + "] Result", Parser.parseSlot(data));
                    break;
                case "minecraft:crafting_shaped":
                    Integer width = Parser.parseVarInt(data);
                    result.packetFields.put("\tRecipe[" + i + "] Width", width);
                    Integer height = Parser.parseVarInt(data);
                    result.packetFields.put("\tRecipe[" + i + "] Height", height);
                    result.packetFields.put("\tRecipe[" + i + "] Group", Parser.parseString(data));
                    for(int j = 0; j < width * height; j++) {
                        parseIngredient(result, "\t\tIngredient[" + j + "]" , data);
                    }
                    result.packetFields.put("\tRecipe[" + i + "] Result", Parser.parseSlot(data));
                    break;
                case "minecraft:smelting":
                case "minecraft:blasting":
                case "minecraft:smoking":
                case "minecraft:campfire_cooking":
                    result.packetFields.put("\tRecipe[" + i + "] Group", Parser.parseString(data));
                    parseIngredient(result, "\tRecipe[" + i + "] Ingredient", data);
                    result.packetFields.put("\tRecipe[" + i + "] Result", Parser.parseSlot(data));
                    result.packetFields.put("\tRecipe[" + i + "] Experience", Parser.parseFloat(data));
                    result.packetFields.put("\tRecipe[" + i + "] Cooking Time", Parser.parseVarInt(data));
                    break;
                case "minecraft:stonecutting":
                    result.packetFields.put("\tRecipe[" + i + "] Group", Parser.parseString(data));
                    parseIngredient(result, "\tIngredient", data);
                    result.packetFields.put("\tRecipe[" + i + "] Result", Parser.parseSlot(data));
                    break;
                case "minecraft:smithing":
                    parseIngredient(result, "\tRecipe[" + i + "] Base", data);
                    parseIngredient(result, "\tRecipe[" + i + "] Addition", data);
                    result.packetFields.put("\tRecipe[" + i + "] Result", Parser.parseSlot(data));
                    break;
            }
        }

        result.printFullPacket = false;

        return result;
    }

    private void parseIngredient(ParseResult result, String prefix, InputStream data) throws IOException {
        Integer count = Parser.parseVarInt(data);
        result.packetFields.put(prefix + " Count", count);
        for(int i = 0; i < count; i++) {
            result.packetFields.put("\t" + prefix + " Item [" + i + "]", Parser.parseSlot(data));
        }
    }
}
