package minecraftpacketparser.parser;

import minecraftpacketparser.parser.datatype.Position;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

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
    void parseBoolean() {
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            assertFalse(Parser.parseBoolean(stream));
        } catch (Exception e) {
            fail();
        }

        val = 0x01;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            assertTrue(Parser.parseBoolean(stream));
        } catch (Exception e) {
            fail();
        }

        val = 0x02;
        InputStream finalStream = new ByteArrayInputStream(new byte[]{val});
        assertThrows(RuntimeException.class, () -> Parser.parseBoolean(finalStream));

        val = -32;
        InputStream finalStream1 = new ByteArrayInputStream(new byte[]{val});
        assertThrows(RuntimeException.class, () -> Parser.parseBoolean(finalStream1));

        InputStream finalStream2 = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseUnsignedByte(finalStream));
    }

    @Test
    void parseByte() {
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assertEquals(0, byt);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 0xFF;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assertEquals(-1, byt);
        } catch (Exception e) {
            fail();
        }

        val = 127;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assertEquals(127, byt);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 128;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assertEquals(-128, byt);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 0x88;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assertEquals(-120, byt);
        } catch (Exception e) {
            fail();
        }

        InputStream finalStream = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseByte(finalStream));
    }

    @Test
    void parseUnsignedByte() {
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assertEquals(0, unsignedByte);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 0xFF;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assertEquals(255, unsignedByte);
        } catch (Exception e) {
            fail();
        }

        val = 127;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assertEquals(127, unsignedByte);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 128;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assertEquals(128, unsignedByte);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 230;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assertEquals(230, unsignedByte);
        } catch (Exception e) {
            fail();
        }

        InputStream finalStream = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseUnsignedByte(finalStream));
    }

    @Test
    void parseShort() {
        InputStream stream = new ByteArrayInputStream(new byte[]{0x00, 0x00});
        try {
            short shortVal = Parser.parseShort(stream);
            assertEquals(0, shortVal);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF});
        try {
            short shortVal = Parser.parseShort(stream);
            assertEquals(-1, shortVal);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF});
        try {
            short shortVal = Parser.parseShort(stream);
            assertEquals(32767, shortVal);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00});
        try {
            short shortVal = Parser.parseShort(stream);
            assertEquals(-32768, shortVal);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{0x03, (byte) 0xF2});
        try {
            short shortVal = Parser.parseShort(stream);
            assertEquals(1010, shortVal);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xD7, (byte) 0x41});
        try {
            short shortVal = Parser.parseShort(stream);
            assertEquals(-10431, shortVal);
        } catch (IOException e) {
            fail();
        }

        // 1 byte, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{0x00});
        assertThrows(RuntimeException.class, () -> Parser.parseShort(finalStream));
    }

    @Test
    void parseUnsignedShort() {
        InputStream stream = new ByteArrayInputStream(new byte[]{0x00, 0x00});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assertEquals(0, unsignedShort);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assertEquals(65535, unsignedShort);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assertEquals(32767, unsignedShort);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assertEquals(32768, unsignedShort);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{0x03, (byte) 0xF2});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assertEquals(1010, unsignedShort);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xD7, (byte) 0x41});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assertEquals(55105, unsignedShort);
        } catch (IOException e) {
            fail();
        }

        // 1 byte, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{0x00});
        assertThrows(RuntimeException.class, () -> Parser.parseUnsignedShort(finalStream));
    }

    @Test
    void parseInt() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            int val = Parser.parseInt(stream);
            assertEquals(0, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        try {
            int val = Parser.parseInt(stream);
            assertEquals(-1, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        try {
            int val = Parser.parseInt(stream);
            assertEquals(2147483647, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            int val = Parser.parseInt(stream);
            assertEquals(-2147483648, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x32, (byte) 0x4F, (byte) 0xCA, (byte) 0xB8});
        try {
            int val = Parser.parseInt(stream);
            assertEquals(844090040, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xF8, (byte) 0x3B, (byte) 0xA0, (byte) 0x43});
        try {
            int val = Parser.parseInt(stream);
            assertEquals(-130310077, val);
        } catch (IOException e) {
            fail();
        }

        // 3 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{0x00, 0x01, 0x02});
        assertThrows(RuntimeException.class, () -> Parser.parseInt(finalStream));
    }

    @Test
    void parseLong() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            long val = Parser.parseLong(stream);
            assertEquals(0, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        try {
            long val = Parser.parseLong(stream);
            assertEquals(-1, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            long val = Parser.parseLong(stream);
            assertEquals(-9223372036854775808L, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFB, (byte) 0x75, (byte) 0xE3, (byte) 0xC8,
                (byte) 0x67, (byte) 0x9D, (byte) 0xA9, (byte) 0x20});
        try {
            long val = Parser.parseLong(stream);
            assertEquals(-327104948043142880L, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x78, (byte) 0xFD, (byte) 0x7E, (byte) 0x6A,
                (byte) 0x01, (byte) 0xAB, (byte) 0x32, (byte) 0x1A});
        try {
            long val = Parser.parseLong(stream);
            assertEquals(8718263447418778138L, val);
        } catch (IOException e) {
            fail();
        }

        // 7 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06});
        assertThrows(RuntimeException.class, () -> Parser.parseLong(finalStream));
    }

    @Test
    void parseFloat() {

        // 123.456
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x42, (byte) 0xF6, (byte) 0xE9, (byte) 0x79});

        try {
            Float val = Parser.parseFloat(stream);
            assertEquals(123.456f, val);
        } catch (IOException e) {
            fail();
        }

        // -123.456
        stream = new ByteArrayInputStream(new byte[]{(byte) 0xC2, (byte) 0xF6, (byte) 0xE9, (byte) 0x79});

        try {
            Float val = Parser.parseFloat(stream);
            assertEquals(-123.456f, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});

        try {
            Float val = Parser.parseFloat(stream);
            assertEquals(0, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});

        try {
            Float val = Parser.parseFloat(stream);
            assertEquals(Float.NaN, val);
        } catch (IOException e) {
            fail();
        }

        // 3 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{0x00, 0x01, 0x02});
        assertThrows(RuntimeException.class, () -> Parser.parseFloat(finalStream));
    }

    @Test
    void parseDouble() {

        // 123.456
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x40, (byte) 0x5E, (byte) 0xDD, (byte) 0x2F,
                (byte) 0x1A, (byte) 0x9F, (byte) 0xBE, (byte) 0x77});

        try {
            Double val = Parser.parseDouble(stream);
            assertEquals(123.456, val);
        } catch (IOException e) {
            fail();
        }

        // -123.456
        stream = new ByteArrayInputStream(new byte[]{(byte) 0xC0, (byte) 0x5E, (byte) 0xDD, (byte) 0x2F,
                (byte) 0x1A, (byte) 0x9F, (byte) 0xBE, (byte) 0x77});

        try {
            Double val = Parser.parseDouble(stream);
            assertEquals(-123.456, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});

        try {
            Double val = Parser.parseDouble(stream);
            assertEquals(0, val);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});

        try {
            Double val = Parser.parseDouble(stream);
            assertEquals(Double.NaN, val);
        } catch (IOException e) {
            fail();
        }

        // 7 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06});
        assertThrows(RuntimeException.class, () -> Parser.parseDouble(finalStream));
    }

    @Test
    void parseAngle() {
        // Same as unsigned byte test
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assertEquals(0, angle);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 0xFF;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assertEquals(255, angle);
        } catch (Exception e) {
            fail();
        }

        val = 127;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assertEquals(127, angle);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 128;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assertEquals(128, angle);
        } catch (Exception e) {
            fail();
        }

        val = (byte) 230;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assertEquals(230, angle);
        } catch (Exception e) {
            fail();
        }

        InputStream finalStream = new ByteArrayInputStream(new byte[]{});
        assertThrows(RuntimeException.class, () -> Parser.parseAngle(finalStream));
    }

    @Test
    void parseVarInt() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(0, varInt);
        } catch (IOException e) {
            fail();
        }

        // Last byte (0xFF) should be ignored in the following test cases

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(0, varInt);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x01, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(1, varInt);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(127, varInt);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x01, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(128, varInt);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0x01, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(255, varInt);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x07, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(2147483647, varInt);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x0F, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(-1, varInt);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x80, (byte) 0x08, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assertEquals(-2147483648, varInt);
        } catch (IOException e) {
            fail();
        }

        // Last byte has 1 in MSB, but no more data left
        InputStream finalStream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream));

        // 6 bytes. Should throw exception.
        InputStream finalStream1 = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream1));
    }

    @Test
    void parseVarLong() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(0, varLong);
        } catch (IOException e) {
            fail();
        }

        // Last byte (0xAB) should be ignored in the following test cases

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(0, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(1, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(127, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(128, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(255, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x07, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(2147483647, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0x7F, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(9223372036854775807L, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(-1, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x80, (byte) 0xF8, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(-2147483648, varLong);
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assertEquals(-9223372036854775808L, varLong);
        } catch (IOException e) {
            fail();
        }

        // Last byte has 1 in MSB, but no more data left
        InputStream finalStream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream));

        // 11 bytes. Should throw exception.
        InputStream finalStream1 = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        assertThrows(RuntimeException.class, () -> Parser.parseVarInt(finalStream1));
    }

    @Test
    void parseString() {
        String str = "test";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseString(stream);
            assertEquals("test", val);
        } catch (IOException e) {
            fail();
        }

        // (length - 1) + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) (str.length()-1)}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseString(stream);
            // Length is one lower, so omit last char
            assertEquals("tes", val);
        } catch (IOException e) {
            fail();
        }

        // (length + 1) + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) (str.length() + 1)}, str.getBytes());
        InputStream finalStream = new ByteArrayInputStream(strBytes);
        // Length is higher than data supplied, so should throw exception
        assertThrows(RuntimeException.class, () -> Parser.parseString(finalStream));
    }

    @Test
    void parseChat() {
        // Chat needs to be a valid JSON object
        String str = "{}";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseChat(stream);
            // Valid JSON, no exception
            assertEquals("{}", val);
        } catch (IOException e) {
            fail();
        }

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
        try {
            String val = Parser.parseChat(stream);
            // Valid JSON, no exception
            assertEquals("{\"test\": true}", val);
        } catch (IOException e) {
            fail();
        }

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
    void parseIdentifier() {
        String str = "test";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseIdentifier(stream);
            // Should be valid identifier. assumed to be in minecraft: namespace
            assertEquals("test", val);
        } catch (IOException e) {
            fail();
        }

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
        try {
            String val = Parser.parseIdentifier(stream);
            // Should be valid identifier
            assertEquals("minecraft:test", val);
        } catch (IOException e) {
            fail();
        }

        str = "minecraft::test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream finalStream2 = new ByteArrayInputStream(strBytes);
        // Colon can't be at beginning of string
        assertThrows(RuntimeException.class, () -> Parser.parseIdentifier(finalStream2));
    }

    @Test
    void parseUUID() {
        InputStream stream = new ByteArrayInputStream(new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06,
                0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F});

        try {
            UUID uuid = Parser.parseUUID(stream);
            assertEquals("00010203-0405-0607-0809-0a0b0c0d0e0f", uuid.toString());
        } catch (IOException e) {
            fail();
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});

        try {
            UUID uuid = Parser.parseUUID(stream);
            assertEquals("ffffffff-ffff-ffff-ffff-ffffffffffff", uuid.toString());
        } catch (IOException e) {
            fail();
        }


        // 15 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        assertThrows(RuntimeException.class, () -> Parser.parseUUID(finalStream));

    }

    @Test
    void parsePosition() {
        // (123, 456, 789)
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x1E, (byte) 0xC0, (byte) 0x00,
                (byte) 0x31, (byte) 0x51, (byte) 0xC8});

        try {
            Position pos = Parser.parsePosition(stream);
            assertEquals(123, pos.x);
            assertEquals(456, pos.y);
            assertEquals(789, pos.z);
        } catch (IOException e) {
            fail();
        }

        // (-123, -456, -789)
        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xE1, (byte) 0x7F, (byte) 0xFF,
                (byte) 0xCE, (byte) 0xBE, (byte) 0x38});

        try {
            Position pos = Parser.parsePosition(stream);
            assertEquals(-123, pos.x);
            assertEquals(-456, pos.y);
            assertEquals(-789, pos.z);
        } catch (IOException e) {
            fail();
        }

        // 15 bytes, not enough data
        InputStream finalStream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF});
        assertThrows(RuntimeException.class, () -> Parser.parsePosition(finalStream));

    }
}