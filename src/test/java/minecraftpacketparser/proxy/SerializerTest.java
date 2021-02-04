package minecraftpacketparser.proxy;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SerializerTest {

    @Test
    void writeVarInt() {
        try {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] expected = {0x00};
            Serializer.writeVarInt(0, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{0x01};
            Serializer.writeVarInt(1, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{0x02};
            Serializer.writeVarInt(2, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{0x7f};
            Serializer.writeVarInt(127, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{(byte) 0x80, 0x01};
            Serializer.writeVarInt(128, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{(byte) 0xff, 0x01};
            Serializer.writeVarInt(255, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{(byte) 0xff, (byte) 0xff, 0x7f};
            Serializer.writeVarInt(2097151, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{(byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, 0x07};
            Serializer.writeVarInt(2147483647, output);
            assertArrayEquals(expected, output.toByteArray());

            output = new ByteArrayOutputStream();
            expected = new byte[]{(byte) 0x80, (byte) 0x80, (byte) 0x80, (byte) 0x80, 0x08};
            Serializer.writeVarInt(-2147483648, output);
            assertArrayEquals(expected, output.toByteArray());


        } catch (IOException e) {
            fail();
        }


    }
}