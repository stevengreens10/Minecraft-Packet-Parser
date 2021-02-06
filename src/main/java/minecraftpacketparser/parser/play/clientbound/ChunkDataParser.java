package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;
import minecraftpacketparser.proxy.Serializer;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.io.SNBTUtil;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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

        result.output = new ByteArrayOutputStream();

        Integer chunkX = Parser.parseInt(data);
        result.packetFields.put("Chunk X", chunkX);
        Serializer.writeInt(chunkX, result.output);

        Integer chunkZ = Parser.parseInt(data);
        result.packetFields.put("Chunk Z", chunkZ);
        Serializer.writeInt(chunkZ, result.output);

        Boolean isFullChunk = Parser.parseBoolean(data);
        result.packetFields.put("Full Chunk?", isFullChunk);
        Serializer.writeBoolean(isFullChunk, result.output);

        int primaryBitMask = Parser.parseVarInt(data);
        result.packetFields.put("Primary Bit Mask", primaryBitMask);
        Serializer.writeVarInt(primaryBitMask, result.output);

        NamedTag nbt = Parser.parseNBT(data);
        result.packetFields.put("Heightmaps", SNBTUtil.toSNBT(nbt.getTag()));
        Serializer.writeNBT(nbt, result.output);

        if(isFullChunk) {
            int biomesLen = Parser.parseVarInt(data);
            result.packetFields.put("Num Biomes", biomesLen);
            Serializer.writeVarInt(biomesLen, result.output);

            for(int i = 0; i < biomesLen; i++) {
                int biome = Parser.parseVarInt(data);
                Serializer.writeVarInt(biome, result.output);
            }
        }

        int dataSize = Parser.parseVarInt(data);
        Serializer.writeVarInt(dataSize, result.output);

        String binaryString = Integer.toBinaryString(primaryBitMask);
        int numSections = 0;
        for(char c : binaryString.toCharArray()) {
            if(c == '1') numSections++;
        }

        ChunkSection[] sections = new ChunkSection[numSections];

        for(int i = 0; i < numSections; i++) {
            ChunkSection section = new ChunkSection();

            section.blockCount = Parser.parseShort(data);
            Serializer.writeShort(section.blockCount, result.output);

            section.bitsPerBlock = Math.max(4, Parser.parseUnsignedByte(data));
            Serializer.writeUnsignedByte(section.bitsPerBlock, result.output);

            section.paletteLength = 0;
            if(section.bitsPerBlock < 9) {
                section.paletteLength = Parser.parseVarInt(data);
                Serializer.writeVarInt(section.paletteLength, result.output);

                section.palette = new int[section.paletteLength];
                for(int j = 0; j < section.paletteLength; j++) {
                    section.palette[j] = Parser.parseVarInt(data);
                    Serializer.writeVarInt((int) Math.floor(Math.random()*17111), result.output);
                }
            } else {
                section.bitsPerBlock = 14;
            }

            int dataArrayLength = Parser.parseVarInt(data);
            Serializer.writeVarInt(dataArrayLength, result.output);

            section.blockData = new long[dataArrayLength];
            for(int j = 0; j < dataArrayLength; j++) {
                section.blockData[j] = Parser.parseLong(data);
                Serializer.writeLong(section.blockData[j], result.output);
            }

            result.packetFields.put("ChunkSection["+i+"]", section);
        }

        int numBlockEntities = Parser.parseVarInt(data);
        Serializer.writeVarInt(numBlockEntities, result.output);

        result.packetFields.put("Num Block Entities", numBlockEntities);

        for(int i = 0; i < numBlockEntities; i++) {
            NamedTag blockEntityNBT = Parser.parseNBT(data);
            Serializer.writeNBT(blockEntityNBT, result.output);

            result.packetFields.put("\tBlock Entity[" + i + "]", blockEntityNBT);
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