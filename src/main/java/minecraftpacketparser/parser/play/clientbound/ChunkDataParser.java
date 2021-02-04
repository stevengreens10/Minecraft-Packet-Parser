package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;
import net.querz.nbt.io.SNBTUtil;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ChunkDataParser extends AbstractPacketParser implements PacketParser {

    public ChunkDataParser(){
        super(State.PLAY, Direction.CLIENTBOUND, "0x20", "ChunkDataParser");
    }

    @Override
    public ParseResult parse(Parser parser, ByteArrayInputStream data) throws IOException {
        super.parse(parser, data);
        ParseResult result = new ParseResult("Chunk Data");
        result.packetFields.put("Chunk X", Parser.parseInt(data));
        result.packetFields.put("Chunk Z", Parser.parseInt(data));
        Boolean isFullChunk = Parser.parseBoolean(data);
        result.packetFields.put("Full Chunk?", isFullChunk);
        int primaryBitMask = Parser.parseVarInt(data);
        result.packetFields.put("Primary Bit Mask", primaryBitMask);
        result.packetFields.put("Heightmaps", SNBTUtil.toSNBT(Parser.parseNBT(data).getTag()));

        if(isFullChunk) {
            int biomesLen = Parser.parseVarInt(data);
            result.packetFields.put("Num Biomes", biomesLen);
            for(int i = 0; i < biomesLen; i++) {

                Parser.parseVarInt(data);
            }
        }

        int dataSize = Parser.parseVarInt(data);
//        byte[] bytes = Parser.readBytes(data, dataSize);
//        result.packetFields.put("Chunk Data", Arrays.toString(bytes));
        String binaryString = Integer.toBinaryString(primaryBitMask);
        int numSections = 0;
        for(char c : binaryString.toCharArray()) {
            if(c == '1') numSections++;
        }

        ChunkSection[] sections = new ChunkSection[numSections];

        for(int i = 0; i < numSections; i++) {
            ChunkSection section = new ChunkSection();
            section.blockCount = Parser.parseShort(data);
            section.bitsPerBlock = Math.max(4, Parser.parseUnsignedByte(data));
            section.paletteLength = 0;
            if(section.bitsPerBlock < 9) {
                section.paletteLength = Parser.parseVarInt(data);
                section.palette = new int[section.paletteLength];
                for(int j = 0; j < section.paletteLength; j++) {
                    section.palette[j] = Parser.parseVarInt(data);
                }
            } else {
                section.bitsPerBlock = 14;
            }

            int dataArrayLength = Parser.parseVarInt(data);
            section.blockData = new long[dataArrayLength];
            for(int j = 0; j < dataArrayLength; j++) {
                section.blockData[j] = Parser.parseLong(data);
            }

            result.packetFields.put("ChunkSection["+i+"]", section);
        }

        int numBlockEntities = Parser.parseVarInt(data);
        result.packetFields.put("Num Block Entities", numBlockEntities);

        for(int i = 0; i < numBlockEntities; i++) {
            result.packetFields.put("\tBlock Entity[" + i + "]", Parser.parseNBT(data));
        }

        result.printFullPacket = false;

        return result;
    }
}

class ChunkSection {
    public Short blockCount;
    public int bitsPerBlock;
    public int paletteLength;
    public int[] palette;
    public long[] blockData;

    @Override
    public String toString() {
        return "ChunkSection{" +
                "blockCount=" + blockCount +
                ", bitsPerBlock=" + bitsPerBlock +
                ", paletteLength=" + paletteLength +
                ", palette=" + Arrays.toString(palette) +
                ", blockData=" + Arrays.toString(blockData) +
                '}';
    }
}