package minecraftpacketparser.parser;

import org.apache.commons.lang3.ArrayUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

class ParserTest {

    @org.junit.jupiter.api.Test
    void intToHexStr() {
        int val = 0;
        assert Parser.intToHexStr(val).equals("0x00");

        val = 255;
        assert Parser.intToHexStr(val).equals("0xFF");

        val = 100;
        assert Parser.intToHexStr(val).equals("0x64");

        val = 232;
        assert Parser.intToHexStr(val).equals("0xE8");
    }

    @org.junit.jupiter.api.Test
    void parseBoolean() {
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            assert !Parser.parseBoolean(stream);
        } catch (Exception e) {
            assert false;
        }

        val = 0x01;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            assert Parser.parseBoolean(stream);
        } catch (Exception e) {
            assert false;
        }

        val = 0x02;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            boolean bool = Parser.parseBoolean(stream);
            assert false;
        } catch (Exception e) {
            // Should throw exception
            assert true;
        }

        val = -32;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            boolean bool = Parser.parseBoolean(stream);
            assert false;
        } catch (Exception e) {
            // Should throw exception
            assert true;
        }
    }

    @org.junit.jupiter.api.Test
    void parseByte() {
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assert byt == 0;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 0xFF;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assert byt == -1;
        } catch (Exception e) {
            assert false;
        }

        val = 127;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assert byt == 127;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 128;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assert byt == -128;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 0x88;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            byte byt = Parser.parseByte(stream);
            assert byt == -120;
        } catch (Exception e) {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void parseUnsignedByte() {
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assert unsignedByte == 0;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 0xFF;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assert unsignedByte == 255;
        } catch (Exception e) {
            assert false;
        }

        val = 127;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assert unsignedByte == 127;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 128;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assert unsignedByte == 128;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 230;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int unsignedByte = Parser.parseUnsignedByte(stream);
            assert unsignedByte == 230;
        } catch (Exception e) {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void parseShort() {
        InputStream stream = new ByteArrayInputStream(new byte[]{0x00, 0x00});
        try {
            short shortVal = Parser.parseShort(stream);
            assert shortVal == 0;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF});
        try {
            short shortVal = Parser.parseShort(stream);
            assert shortVal == -1;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF});
        try {
            short shortVal = Parser.parseShort(stream);
            assert shortVal == 32767;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00});
        try {
            short shortVal = Parser.parseShort(stream);
            assert shortVal == -32768;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{0x03, (byte) 0xF2});
        try {
            short shortVal = Parser.parseShort(stream);
            assert shortVal == 1010;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xD7, (byte) 0x41});
        try {
            short shortVal = Parser.parseShort(stream);
            assert shortVal == -10431;
        } catch (IOException e) {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void parseUnsignedShort() {
        InputStream stream = new ByteArrayInputStream(new byte[]{0x00, 0x00});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assert unsignedShort == 0;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assert unsignedShort == 65535;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assert unsignedShort == 32767;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assert unsignedShort == 32768;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{0x03, (byte) 0xF2});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assert unsignedShort == 1010;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xD7, (byte) 0x41});
        try {
            int unsignedShort = Parser.parseUnsignedShort(stream);
            assert unsignedShort == 55105;
        } catch (IOException e) {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void parseInt() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            int val = Parser.parseInt(stream);
            assert val == 0;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        try {
            int val = Parser.parseInt(stream);
            assert val == -1;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        try {
            int val = Parser.parseInt(stream);
            assert val == 2147483647;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            int val = Parser.parseInt(stream);
            assert val == -2147483648;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x32, (byte) 0x4F, (byte) 0xCA, (byte) 0xB8});
        try {
            int val = Parser.parseInt(stream);
            assert val == 844090040;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xF8, (byte) 0x3B, (byte) 0xA0, (byte) 0x43});
        try {
            int val = Parser.parseInt(stream);
            assert val == -130310077;
        } catch (IOException e) {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void parseLong() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            long val = Parser.parseLong(stream);
            assert val == 0;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        try {
            long val = Parser.parseLong(stream);
            assert val == -1;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x00, (byte) 0x00, (byte) 0x00,
                (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00});
        try {
            long val = Parser.parseLong(stream);
            assert val == -9223372036854775808L;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFB, (byte) 0x75, (byte) 0xE3, (byte) 0xC8,
                (byte) 0x67, (byte) 0x9D, (byte) 0xA9, (byte) 0x20});
        try {
            long val = Parser.parseLong(stream);
            assert val == -327104948043142880L;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x78, (byte) 0xFD, (byte) 0x7E, (byte) 0x6A,
                (byte) 0x01, (byte) 0xAB, (byte) 0x32, (byte) 0x1A});
        try {
            long val = Parser.parseLong(stream);
            assert val == 8718263447418778138L;
        } catch (IOException e) {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void parseAngle() {
        // Same as unsigned byte test
        byte val = 0x00;
        InputStream stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assert angle == 0;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 0xFF;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assert angle == 255;
        } catch (Exception e) {
            assert false;
        }

        val = 127;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assert angle == 127;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 128;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assert angle == 128;
        } catch (Exception e) {
            assert false;
        }

        val = (byte) 230;
        stream = new ByteArrayInputStream(new byte[]{val});
        try {
            int angle = Parser.parseAngle(stream);
            assert angle == 230;
        } catch (Exception e) {
            assert false;
        }
    }

    @org.junit.jupiter.api.Test
    void parseVarInt() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == 0;
        } catch (IOException e) {
            assert false;
        }

        // Last byte (0xFF) should be ignored in the following test cases

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == 0;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x01, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == 1;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == 127;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x01, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == 128;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0x01, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == 255;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x07, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == 2147483647;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x0F, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == -1;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x80, (byte) 0x08, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert varInt == -2147483648;
        } catch (IOException e) {
            assert false;
        }

        // 6 bytes. Should throw exception.
        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF});
        try {
            int varInt = Parser.parseVarInt(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            assert true;
        }

    }

    @org.junit.jupiter.api.Test
    void parseVarLong() {
        InputStream stream = new ByteArrayInputStream(new byte[]{(byte) 0x00});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 0;
        } catch (IOException e) {
            assert false;
        }

        // Last byte (0xAB) should be ignored in the following test cases

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x00, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 0;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 1;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x7F, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 127;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 128;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 255;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x07, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 2147483647;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0x7F, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == 9223372036854775807L;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == -1;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x80, (byte) 0xF8, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == -2147483648;
        } catch (IOException e) {
            assert false;
        }

        stream = new ByteArrayInputStream(new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80,
                (byte) 0x01, (byte) 0xAB});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert varLong == -9223372036854775808L;
        } catch (IOException e) {
            assert false;
        }

        // 11 bytes. Should throw exception.
        stream = new ByteArrayInputStream(new byte[]{(byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF,
                (byte) 0xFF, (byte) 0xFF});
        try {
            long varLong = Parser.parseVarLong(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            assert true;
        }
    }

    @org.junit.jupiter.api.Test
    void parseString() {
        String str = "test";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseString(stream);
            assert val.equals("test");
        } catch (IOException e) {
            assert false;
        }

        // (length - 1) + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) (str.length()-1)}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseString(stream);
            // Length is one lower, so omit last char
            assert val.equals("tes");
        } catch (IOException e) {
            assert false;
        }

        // (length + 1) + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) (str.length()+1)}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseString(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            // Length is higher than data supplied, so should throw exception
            assert true;
        }
    }

    @org.junit.jupiter.api.Test
    void parseChat() {
        // Chat needs to be a valid JSON object
        String str = "{}";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseChat(stream);
            // Valid JSON, no exception
            assert val.equals("{}");
        } catch (IOException e) {
            assert false;
        }

        str = "{";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseChat(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            // Invalid JSON, throw exception
            assert true;
        }

        str = "{\"test\": true}";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseChat(stream);
            // Valid JSON, no exception
            assert val.equals("{\"test\": true}");
        } catch (IOException e) {
            assert false;
        }

        str = "{test}";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseChat(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            // Invalid JSON, throw exception
            assert true;
        }

        str = "normalMessage";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseChat(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            // Invalid JSON, throw exception
            assert true;
        }
    }

    @org.junit.jupiter.api.Test
    void parseIdentifier() {
        String str = "test";
        // length + string bytes
        byte[] strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        InputStream stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseIdentifier(stream);
            // Should be valid identifier. assumed to be in minecraft: namespace
            assert val.equals("test");
        } catch (IOException e) {
            assert false;
        }

        str = "@test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseIdentifier(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            // Should be invalid identifier. only alphanumeric chars allowed
            assert true;
        }

        str = ":test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseIdentifier(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            // Should be invalid identifier. colon can't start string
            assert true;
        }

        str = "minecraft:test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseIdentifier(stream);
            // Should be valid identifier
            assert val.equals("minecraft:test");
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            assert true;
        }

        str = "minecraft::test";
        // length + string bytes
        strBytes = ArrayUtils.addAll(new byte[]{(byte) str.length()}, str.getBytes());
        stream = new ByteArrayInputStream(strBytes);
        try {
            String val = Parser.parseIdentifier(stream);
            assert false;
        } catch (IOException e) {
            assert false;
        } catch (RuntimeException e) {
            // Should be invalid identifier. only one colon allowed
            assert true;
        }
    }
}