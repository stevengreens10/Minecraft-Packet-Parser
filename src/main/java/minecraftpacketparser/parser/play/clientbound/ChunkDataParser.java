package minecraftpacketparser.parser.play.clientbound;

import minecraftpacketparser.parser.*;
import minecraftpacketparser.proxy.Serializer;
import net.querz.nbt.io.NamedTag;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
        ChunkData chunkData = new ChunkData();

        chunkData.chunkX = Parser.parseInt(data);
        chunkData.chunkZ = Parser.parseInt(data);
        chunkData.fullChunk = Parser.parseBoolean(data);
        chunkData.primaryBitMask = Parser.parseVarInt(data);
        chunkData.heightmaps = Parser.parseNBT(data);

        if(chunkData.fullChunk) {
            int biomesLen = Parser.parseVarInt(data);
            chunkData.biomes = new int[biomesLen];
            for(int i = 0; i < biomesLen; i++) {
                chunkData.biomes[i] = Parser.parseVarInt(data);
            }
        }

        chunkData.dataSize = Parser.parseVarInt(data);

        String binaryString = Integer.toBinaryString(chunkData.primaryBitMask);
        int numSections = 0;
        for(char c : binaryString.toCharArray()) {
            if(c == '1') numSections++;
        }

        chunkData.sections = new ChunkSection[numSections];
        int sizeAdjustment = 0;

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
                    int numBytesBefore = Parser.getNumBytesInVarInt(section.palette[j]);
                    section.palette[j] = (int) Math.floor(Math.random()*17000);
                    int numBytesAfter = Parser.getNumBytesInVarInt(section.palette[j]);

                    sizeAdjustment += numBytesAfter - numBytesBefore;
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

            chunkData.sections[i] = section;
        }

        chunkData.dataSize += sizeAdjustment;

        int numBlockEntities = Parser.parseVarInt(data);

        chunkData.blockEntities = new NamedTag[numBlockEntities];

        for(int i = 0; i < numBlockEntities; i++) {
            chunkData.blockEntities[i] = Parser.parseNBT(data);
        }

        chunkData.printFullData = false;

        result.packetFields.put("Chunk Data", chunkData);
        serializeChunkData(chunkData, result.output);

        return result;
    }

    public static void serializeChunkData(ChunkData chunkData, OutputStream output) throws IOException {
        // packet ID
        Serializer.writeVarInt(32, output);

        Serializer.writeInt(chunkData.chunkX, output);
        Serializer.writeInt(chunkData.chunkZ, output);
        Serializer.writeBoolean(chunkData.fullChunk, output);
        Serializer.writeVarInt(chunkData.primaryBitMask, output);
        Serializer.writeNBT(chunkData.heightmaps, output);

        if(chunkData.fullChunk) {
            Serializer.writeVarInt(chunkData.biomes.length, output);
            for(int i = 0; i < chunkData.biomes.length; i++) {
                Serializer.writeVarInt(chunkData.biomes[i], output);
            }
        }

        Serializer.writeVarInt(chunkData.dataSize, output);
        for(int i = 0; i < chunkData.sections.length; i++) {
            ChunkSection section = chunkData.sections[i];
            Serializer.writeShort(section.blockCount, output);
            Serializer.writeUnsignedByte(section.bitsPerBlock, output);

            if(section.bitsPerBlock < 9) {
                Serializer.writeVarInt(section.paletteLength, output);
                for(int j = 0; j < section.paletteLength; j++) {
                    Serializer.writeVarInt(section.palette[j], output);
                }
            }

            Serializer.writeVarInt(section.blockData.length, output);

            for(int j = 0; j < section.blockData.length; j++) {
                Serializer.writeLong(section.blockData[j], output);
            }
        }
    }
}

class ChunkData {
    public int chunkX;
    public int chunkZ;
    public boolean fullChunk;
    public int primaryBitMask;
    public NamedTag heightmaps;
    public int[] biomes;
    public int dataSize;
    public ChunkSection[] sections;
    public NamedTag[] blockEntities;

    public boolean printFullData = false;

    @Override
    public String toString() {
        if(printFullData)
            return "ChunkData{" +
                    "\n\tchunkX=" + chunkX +
                    "\n\tchunkZ=" + chunkZ +
                    "\n\tfullChunk=" + fullChunk +
                    "\n\tprimaryBitMask=" + primaryBitMask +
                    "\n\theightmaps=" + heightmaps +
                    "\n\tbiomes=" + Arrays.toString(biomes) +
                    "\n\tdataSize=" + dataSize +
                    "\n\tsections=" + Arrays.toString(sections) +
                    "\n\tblockEntities=" + Arrays.toString(blockEntities) +
                    "\n}";

        return "ChunkData{" +
                "\n\tchunkX=" + chunkX +
                "\n\tchunkZ=" + chunkZ +
                "\n\tfullChunk=" + fullChunk +
                "\n\tprimaryBitMask=" + primaryBitMask +
                "\n\theightmaps=" + heightmaps +
                "\n\tdataSize=" + dataSize +
                "\n\tblockEntities=" + Arrays.toString(blockEntities) +
                '}';
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