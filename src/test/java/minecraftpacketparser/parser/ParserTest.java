package minecraftpacketparser.parser;

import minecraftpacketparser.parser.datatype.Position;
import minecraftpacketparser.parser.datatype.Slot;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void handlePacket() {
//        try {
//            byte[] bytes = Hex.decodeHex("ff790a29c40c00520000ff81010a29a20c000000000000010946a40c014afd8dff530a29a40cffd60000fff801043ca40ce60946c20cfe6efd8dffcf0c2ac20cffb40000ff44c20001043cc20cc30a29d4110000003d0000000946bc0c00ddfd8d08330a29bc0c000000000000010946ba0c0104fd8d01a80a29ba0c02d6000004aa01043cba0ce90a29db0c000000000000010a29b30c000000000000010946ab0c013efd8dfff70a29ab0c000000000000010a29c30c000000000000010946d30c0075fd8dfdcf0c2ad30c006e0000fdf2a30001043cd30c9e0946a30c007ffd8d00600a29a30c00000000fdbc010a29f10c000000000000010946bb0cff27fd8dfd4f0a29bb0c00000000fedd010946b00cfec2fd8dff0c0a29b00c00000000ff94010946ac0c020afd8d041d0a29ac0cfeed00000078010946b40cfff5fd8dfec40a29b40cff650000003601043cb40c270946a80cff68fd8dfed90a29a80c00cf0000ff3c01043ca80ca30a29f90c030d0000fcf2010a29fa0c000000000000010946ea0c017bfd8d0000043cea0c1f0946e60c00f5fd8d002e0a29e60c00e70000002c010946ad0c0050fd8dfda90a29ad0c01100000011e010946b50c00c9fd8d02b60a29b50cff5b000001a7010946c00cff1afd8dfe940a29c00cfdd80000000c010946e00c0092fd8dff2f0c2ae00cff2f0000ff627900010946c60c0191fd8d00000a29c60cfece00000000010c2ad611004202d1fd4c390000043cd6116f0946be0c0094fd8dff1a0a29be0c004400000000010946b80cfefdfd8d02020a29b80c005c00000081010946d80c01d2fd8dfd330a29d80c00d000000000010946d70c001dfd8dffc20c2ad7110000021600b1e50000043cd711c40946cf0c00e5fd8dfee10a29cf0c004c0000004c01043ccf0cf50946cc0c028efd8d03530946d90c0002fd8d017b0c2ad90c004b0000000d8100010946da0c0223fd8d03960c2ada0c014b000000b3ad0001043cda0caa0946cd0cfbb3fd8dfd330946d50cfccbfd8d00000a29d50cffc500000000010946dc0cff4cfd8dff650a29dc0cff8a00000000010946c40cff82fd8dff220a29c40c00ec00000013010a29830d000000000000010946c20cfdb7fd8d01320c2ac20c002c00000000c40001043cc20cc20c2aae0efe8d016106f9061a000a29fb0c00000000000001043cfb0c830a29fc0c000000000000000946a30cfed8fd8dfee50a29a30c004100000032010946840dfe54fd8d01690a29840dfced0000029701043c840d230946bb0cfe8ffd8dfef60a29bb0c00000000fecf01");
//            try {
//                Parser.initialize();
//                Parser.handlePacket(new ByteArrayInputStream(bytes), Direction.CLIENTBOUND, System.out);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        } catch (DecoderException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    void intToHexStr() {
        int val = 0;
        assertEquals("0x00", Parser.intToHexStr(val));

        val = 255;
        assertEquals(("0xFF"), Parser.intToHexStr(val));

        val = 100;
        assertEquals("0x64", Parser.intToHexStr(val));

        val = 232;
        assertEquals("0xE8", Parser.intToHexStr(val));
    }

    @Test
    void parseBoolean() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertFalse(Parser.parseBoolean(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("01"));
        assertTrue(Parser.parseBoolean(stream));

        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("02"));
        assertThrows(RuntimeException.class, () -> Parser.parseBoolean(finalStream));

        // -32
        InputStream finalStream1 = new ByteArrayInputStream(Hex.decodeHex("E0"));
        assertThrows(RuntimeException.class, () -> Parser.parseBoolean(finalStream1));

        InputStream finalStream2 = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseUnsignedByte(finalStream));
    }

    @Test
    void parseByte() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertEquals((byte) 0, Parser.parseByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FF"));
        assertEquals((byte) -1, Parser.parseByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7F"));
        assertEquals((byte) 127, Parser.parseByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("80"));
        assertEquals((byte) -128, Parser.parseByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("88"));
        assertEquals((byte) -120, Parser.parseByte(stream));

        InputStream finalStream = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseByte(finalStream));
    }

    @Test
    void parseUnsignedByte() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertEquals(0, Parser.parseUnsignedByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FF"));
        assertEquals(255, Parser.parseUnsignedByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7F"));
        assertEquals(127, Parser.parseUnsignedByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("80"));
        assertEquals(128, Parser.parseUnsignedByte(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("E6"));
        assertEquals(230, Parser.parseUnsignedByte(stream));

        InputStream finalStream = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseUnsignedByte(finalStream));
    }

    @Test
    void parseShort() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("0000"));
        assertEquals((short) 0, Parser.parseShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFF"));
        assertEquals((short) -1, Parser.parseShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7FFF"));
        assertEquals((short) 32767, Parser.parseShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("8000"));
        assertEquals((short) -32768, Parser.parseShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("03F2"));
        assertEquals((short) 1010, Parser.parseShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("D741"));
        assertEquals((short) -10431, Parser.parseShort(stream));

        // 1 byte, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertThrows(RuntimeException.class, () -> Parser.parseShort(finalStream));
    }

    @Test
    void parseUnsignedShort() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("0000"));
        assertEquals(0, Parser.parseUnsignedShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFF"));
        assertEquals(65535, Parser.parseUnsignedShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7FFF"));
        assertEquals(32767, Parser.parseUnsignedShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("8000"));
        assertEquals(32768, Parser.parseUnsignedShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("03F2"));
        assertEquals(1010, Parser.parseUnsignedShort(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("D741"));
        assertEquals(55105, Parser.parseUnsignedShort(stream));

        // 1 byte, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertThrows(RuntimeException.class, () -> Parser.parseUnsignedShort(finalStream));
    }

    @Test
    void parseInt() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00000000"));
        assertEquals(0, Parser.parseInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFF"));
        assertEquals(-1, Parser.parseInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7FFFFFFF"));
        assertEquals(2147483647, Parser.parseInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("80000000"));
        assertEquals(-2147483648, Parser.parseInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("324FCAB8"));
        assertEquals(844090040, Parser.parseInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("F83BA043"));
        assertEquals(-130310077, Parser.parseInt(stream));

        // 3 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("000102"));
        assertThrows(RuntimeException.class, () -> Parser.parseInt(finalStream));
    }

    @Test
    void parseLong() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("0000000000000000"));
        assertEquals(0L, Parser.parseLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFFFF"));
        assertEquals(-1L, Parser.parseLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("8000000000000000"));
        assertEquals(-9223372036854775808L, Parser.parseLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FB75E3C8679DA920"));
        assertEquals(-327104948043142880L, Parser.parseLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("78FD7E6A01AB321A"));
        assertEquals(8718263447418778138L, Parser.parseLong(stream));

        // 7 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("00010203040506"));
        assertThrows(RuntimeException.class, () -> Parser.parseLong(finalStream));
    }

    @Test
    void parseFloat() throws IOException, DecoderException {

        // 123.456
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("42F6E979"));
        assertEquals(123.456f, Parser.parseFloat(stream));

        // -123.456
        stream = new ByteArrayInputStream(Hex.decodeHex("C2F6E979"));
        assertEquals(-123.456f, Parser.parseFloat(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("00000000"));
        assertEquals(0, Parser.parseFloat(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFF"));
        assertEquals(Float.NaN, Parser.parseFloat(stream));

        // 3 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("000102"));
        assertThrows(RuntimeException.class, () -> Parser.parseFloat(finalStream));
    }

    @Test
    void parseDouble() throws IOException, DecoderException {

        // 123.456
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("405EDD2F1A9FBE77"));
        assertEquals(123.456, Parser.parseDouble(stream));

        // -123.456
        stream = new ByteArrayInputStream(Hex.decodeHex("C05EDD2F1A9FBE77"));
        assertEquals(-123.456, Parser.parseDouble(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("0000000000000000"));
        assertEquals(0, Parser.parseDouble(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFFFF"));
        assertEquals(Double.NaN, Parser.parseDouble(stream));

        // 7 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("00010203040506"));
        assertThrows(RuntimeException.class, () -> Parser.parseDouble(finalStream));
    }

    @Test
    void parseAngle() throws IOException, DecoderException {
        // Same as unsigned byte test
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertEquals(0, Parser.parseAngle(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FF"));
        assertEquals(255, Parser.parseAngle(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7F"));
        assertEquals(127, Parser.parseAngle(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("80"));
        assertEquals(128, Parser.parseAngle(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("E6"));
            assertEquals(230, Parser.parseAngle(stream));

        InputStream finalStream = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseAngle(finalStream));
    }

    @Test
    void parseVarInt() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertEquals(0, Parser.parseVarInt(stream));

        // Last byte (0xFF) should be ignored in the following test cases
        stream = new ByteArrayInputStream(Hex.decodeHex("00FF"));
        assertEquals(0, Parser.parseVarInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("01FF"));
        assertEquals(1, Parser.parseVarInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7FFF"));
        assertEquals(127, Parser.parseVarInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("8001FF"));
        assertEquals(128, Parser.parseVarInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FF01FF"));
        assertEquals(255, Parser.parseVarInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFF07FF"));
        assertEquals(2147483647, Parser.parseVarInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFF0FFF"));
        assertEquals(-1, Parser.parseVarInt(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("8080808008FF"));
        assertEquals(-2147483648, Parser.parseVarInt(stream));

        // Last byte has 1 in MSB, but no more data left
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("FFFFFF"));
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream));

        // 6 bytes. Should throw exception.
        InputStream finalStream1 = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFF"));
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream1));
    }

    @Test
    void parseVarLong() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00"));
        assertEquals(0, Parser.parseVarLong(stream));

        // Last byte (0xAB) should be ignored in the following test cases
        stream = new ByteArrayInputStream(Hex.decodeHex("00AB"));
        assertEquals(0, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("01AB"));
        assertEquals(1, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("7FAB"));
        assertEquals(127, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("8001AB"));
        assertEquals(128, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FF01AB"));
        assertEquals(255, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFF07AB"));
        assertEquals(2147483647, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFFFF7FAB"));
        assertEquals(9223372036854775807L, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFFFFFF01AB"));
        assertEquals(-1, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("80808080F8FFFFFFFF01AB"));
        assertEquals(-2147483648, Parser.parseVarLong(stream));

        stream = new ByteArrayInputStream(Hex.decodeHex("80808080808080808001AB"));
        assertEquals(-9223372036854775808L, Parser.parseVarLong(stream));

        // Last byte has 1 in MSB, but no more data left
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFF"));
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream));

        // 11 bytes. Should throw exception.
        InputStream finalStream1 = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFFFFFFFFFF"));
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream1));
    }

    @Test
    void parseString() throws IOException {
        String str = "test";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        assertEquals("test", Parser.parseString(stream));

        // (length - 1) + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) (str.length()-1)}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        assertEquals("tes", Parser.parseString(stream));

        // (length + 1) + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) (str.length() + 1)}, str.getBytes());
        InputStream finalStream = new ByteArrayInputStream(strBytes);
        // Length is higher than data supplied, so should throw exception
        assertThrows(RuntimeException.class, () -> Parser.parseString(finalStream));
    }

    @Test
    void parseChat() throws IOException {
        // Chat needs to be a valid JSON object
        String str = "{}";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        // Valid JSON, no exception
        assertEquals("{}", Parser.parseChat(stream));

        str = "{";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream finalStream = new ByteArrayInputStream(strBytes);
        // Invalid JSON, should throw exception
        assertThrows(RuntimeException.class, () -> Parser.parseChat(finalStream));

        str = "{\"test\": true}";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        // Valid JSON, no exception
        assertEquals("{\"test\": true}", Parser.parseChat(stream));

        str = "{test}";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream finalStream1 = new ByteArrayInputStream(strBytes);
        // Invalid JSON, should throw exception
        assertThrows(RuntimeException.class, () -> Parser.parseChat(finalStream1));

        str = "normalMessage";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream finalStream2 = new ByteArrayInputStream(strBytes);
        // Invalid JSON, should throw exception
        assertThrows(RuntimeException.class, () -> Parser.parseChat(finalStream2));
    }

    @Test
    void parseIdentifier() throws IOException {
        String str = "test";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        // Should be valid identifier. assumed to be in minecraft: namespace
        assertEquals("test", Parser.parseIdentifier(stream));

        str = "@test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream finalStream = new ByteArrayInputStream(strBytes);
        // Only alphanumeric chars allowed (and colon)
        assertThrows(RuntimeException.class, () -> Parser.parseIdentifier(finalStream));

        str = ":test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream finalStream1 = new ByteArrayInputStream(strBytes);
        // Colon can't be at beginning of string
        assertThrows(RuntimeException.class, () -> Parser.parseIdentifier(finalStream1));

        str = "minecraft:test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        // Should be valid identifier
        assertEquals("minecraft:test", Parser.parseIdentifier(stream));

        str = "minecraft::test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream finalStream2 = new ByteArrayInputStream(strBytes);
        // Colon can't be at beginning of string
        assertThrows(RuntimeException.class, () -> Parser.parseIdentifier(finalStream2));
    }

    @Test
    void parseUUID() throws IOException, DecoderException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("000102030405060708090A0B0C0D0E0F"));
        assertEquals("00010203-0405-0607-0809-0a0b0c0d0e0f", Parser.parseUUID(stream).toString());

        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));
        assertEquals("ffffffff-ffff-ffff-ffff-ffffffffffff", Parser.parseUUID(stream).toString());

        // 15 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFF"));
        assertThrows(RuntimeException.class, () -> Parser.parseUUID(finalStream));
    }

    @Test
    void parsePosition() throws IOException, DecoderException {
        // (123, 456, 789)
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("00001EC0003151C8"));
        Position pos = Parser.parsePosition(stream);
        assertEquals(123, pos.x);
        assertEquals(456, pos.y);
        assertEquals(789, pos.z);

        // (-123, -456, -789)
        stream = new ByteArrayInputStream(Hex.decodeHex("FFFFE17FFFCEBE38"));
        pos = Parser.parsePosition(stream);
        assertEquals(-123, pos.x);
        assertEquals(-456, pos.y);
        assertEquals(-789, pos.z);

        // 7 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("FFFFFFFFFFFFFF"));
        assertThrows(RuntimeException.class, () -> Parser.parsePosition(finalStream));
    }

    /*
    @Test
    void parseNBT() throws DecoderException, IOException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("0A000B68656C6C6F20776F726C640800046E616D65000942616E616E72616D6100"));
        Tag<?> nbt = Parser.parseNBT(stream);
        assertEquals(TagType.TAG_COMPOUND, nbt.getType());
        assertEquals("hello world", nbt.getName());
        CompoundTag root = (CompoundTag) nbt;
        assertTrue(root.getValue().containsKey("name"));
        assertEquals(TagType.TAG_STRING, root.getValue().get("name").getType());
        Tag<String> nameTag = (StringTag) root.getValue().get("name");
        assertEquals("Bananrama", nameTag.getValue());

        stream = new ByteArrayInputStream(Hex.decodeHex("0A00054C6576656C0400086C6F6E67546573747FFFFFFFFFFFFFFF02000973686F7274546573747FFF08" +
                "000A737472696E6754657374002948454C4C4F20574F524C4420544849532049532041205445535420535452494E4720C385C384C39621050009666C6" +
                "F6174546573743EFF1832030007696E74546573747FFFFFFF0A00146E657374656420636F6D706F756E6420746573740A000368616D0800046E616D65000" +
                "648616D70757305000576616C75653F400000000A00036567670800046E616D6500074567676265727405000576616C75653F000000000009000F6C69737" +
                "45465737420286C6F6E67290400000005000000000000000B000000000000000C000000000000000D000000000000000E000000000000000F0900136C6973" +
                "74546573742028636F6D706F756E64290A000000020800046E616D65000F436F6D706F756E642074616720233004000A637265617465642D6F6E000001265" +
                "237D58D000800046E616D65000F436F6D706F756E642074616720233104000A637265617465642D6F6E000001265237D58D0001000862797465546573747F" +
                "06000A646F75626C65546573743FDF8F6BBBFF6A5E00"));
        nbt = Parser.parseNBT(stream);
        assertEquals(TagType.TAG_COMPOUND, nbt.getType());
        root = (CompoundTag) nbt;
        assertEquals("Level", root.getName());
        assertEquals(10, root.getValue().size());

        assertEquals(TagType.TAG_BYTE, root.getValue().get("byteTest").getType());
        ByteTag byteTest = (ByteTag) root.getValue().get("byteTest");
        assertEquals("byteTest", byteTest.getName());
        assertEquals((byte) 127, byteTest.getValue());

        assertEquals(TagType.TAG_DOUBLE, root.getValue().get("doubleTest").getType());
        DoubleTag doubleTest = (DoubleTag) root.getValue().get("doubleTest");
        assertEquals("doubleTest", doubleTest.getName());
        assertEquals(0.4931287132182315, doubleTest.getValue());

        assertEquals(TagType.TAG_FLOAT, root.getValue().get("floatTest").getType());
        FloatTag floatTest = (FloatTag) root.getValue().get("floatTest");
        assertEquals("floatTest", floatTest.getName());
        assertEquals(0.4982314705848694f, floatTest.getValue());

        assertEquals(TagType.TAG_INT, root.getValue().get("intTest").getType());
        IntTag intTest = (IntTag) root.getValue().get("intTest");
        assertEquals("intTest", intTest.getName());
        assertEquals(2147483647, intTest.getValue());

        assertEquals(TagType.TAG_LIST, root.getValue().get("listTest (compound)").getType());
        ListTag<?> listTestCompound = (ListTag<?>) root.getValue().get("listTest (compound)");
        assertEquals("listTest (compound)", listTestCompound.getName());
        assertEquals(CompoundTag.class, listTestCompound.getElementType());
        assertEquals(2, listTestCompound.getValue().size());
        CompoundTag elt0 = (CompoundTag) listTestCompound.getValue().get(0);
        CompoundTag elt1 = (CompoundTag) listTestCompound.getValue().get(1);
        assertEquals(TagType.TAG_STRING, elt0.getValue().get("name").getType());
        assertEquals(TagType.TAG_LONG, elt0.getValue().get("created-on").getType());
        assertEquals(TagType.TAG_STRING, elt1.getValue().get("name").getType());
        assertEquals(TagType.TAG_LONG, elt1.getValue().get("created-on").getType());
        assertEquals("Compound tag #0", elt0.getValue().get("name").getValue());
        assertEquals("Compound tag #1", elt1.getValue().get("name").getValue());
        assertEquals(1264099775885L, ((LongTag) elt0.getValue().get("created-on")).getValue());
        assertEquals(1264099775885L, ((LongTag) elt1.getValue().get("created-on")).getValue());

        assertEquals(TagType.TAG_LIST, root.getValue().get("listTest (long)").getType());
        ListTag<?> listTestLong = (ListTag<?>) root.getValue().get("listTest (long)");
        assertEquals("listTest (long)", listTestLong.getName());
        assertEquals(LongTag.class, listTestLong.getElementType());
        assertEquals(5, listTestLong.getValue().size());
        assertEquals(11L, ((LongTag) listTestLong.getValue().get(0)).getValue());
        assertEquals(12L, ((LongTag) listTestLong.getValue().get(1)).getValue());
        assertEquals(13L, ((LongTag) listTestLong.getValue().get(2)).getValue());
        assertEquals(14L, ((LongTag) listTestLong.getValue().get(3)).getValue());
        assertEquals(15L, ((LongTag) listTestLong.getValue().get(4)).getValue());

        assertEquals(TagType.TAG_LONG, root.getValue().get("longTest").getType());
        LongTag longTest = (LongTag) root.getValue().get("longTest");
        assertEquals("longTest", longTest.getName());
        assertEquals(9223372036854775807L, longTest.getValue());

        assertEquals(TagType.TAG_COMPOUND, root.getValue().get("nested compound test").getType());
        CompoundTag nestedCompoundTest = (CompoundTag) root.getValue().get("nested compound test");
        assertEquals("nested compound test", nestedCompoundTest.getName());
        assertEquals(TagType.TAG_COMPOUND, nestedCompoundTest.getValue().get("egg").getType());
        assertEquals(TagType.TAG_COMPOUND, nestedCompoundTest.getValue().get("ham").getType());
        CompoundTag eggCompound = (CompoundTag) nestedCompoundTest.getValue().get("egg");
        CompoundTag hamCompound = (CompoundTag) nestedCompoundTest.getValue().get("ham");
        assertEquals(TagType.TAG_STRING, eggCompound.getValue().get("name").getType());
        assertEquals(TagType.TAG_FLOAT, eggCompound.getValue().get("value").getType());
        assertEquals("Eggbert", eggCompound.getValue().get("name").getValue());
        assertEquals(0.5f, ((FloatTag) eggCompound.getValue().get("value")).getValue());
        assertEquals(TagType.TAG_STRING, hamCompound.getValue().get("name").getType());
        assertEquals(TagType.TAG_FLOAT, hamCompound.getValue().get("value").getType());
        assertEquals("Hampus", hamCompound.getValue().get("name").getValue());
        assertEquals(0.75f, ((FloatTag) hamCompound.getValue().get("value")).getValue());

        assertEquals(TagType.TAG_SHORT, root.getValue().get("shortTest").getType());
        ShortTag shortTest = (ShortTag) root.getValue().get("shortTest");
        assertEquals("shortTest", shortTest.getName());
        assertEquals((short) 32767, shortTest.getValue());

        assertEquals(TagType.TAG_STRING, root.getValue().get("stringTest").getType());
        StringTag stringTest = (StringTag) root.getValue().get("stringTest");
        assertEquals("stringTest", stringTest.getName());
        assertEquals("HELLO WORLD THIS IS A TEST STRING ÅÄÖ!", stringTest.getValue());
    }*/

    @Test
    void parseSlot() throws DecoderException, IOException {
        InputStream stream = new ByteArrayInputStream(Hex.decodeHex("019604010A000003000644616D6167650000000400"));
        Slot slot = Parser.parseSlot(stream);
        assertTrue(slot.present);
        assertEquals(534, slot.itemID);
        assertEquals(1, slot.itemCount);
        /*
        assertEquals(TagType.TAG_COMPOUND, slot.nbtData.getType());
        assertTrue(((CompoundTag) slot.nbtData).getValue().containsKey("Damage"));
        assertEquals(4, ((CompoundTag) slot.nbtData).getValue().get("Damage").getValue());

        stream = new ByteArrayInputStream(Hex.decodeHex("0186050B00"));
        slot = Parser.parseSlot(stream);
        assertTrue(slot.present);
        assertEquals(646, slot.itemID);
        assertEquals(11, slot.itemCount);
        assertEquals(TagType.TAG_END, slot.nbtData.getType());
*/
        stream = new ByteArrayInputStream(Hex.decodeHex("00"));
        slot = Parser.parseSlot(stream);
        assertFalse(slot.present);
        assertNull(slot.nbtData);

        // Present flag is set, but no data comes after.
        // Should throw exception
        InputStream finalStream = new ByteArrayInputStream(Hex.decodeHex("01"));
        assertThrows(RuntimeException.class, () ->Parser.parseSlot(finalStream));
    }
}