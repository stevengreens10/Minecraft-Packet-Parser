package minecraftpacketparser.proxy;

import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.StringTag;
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

    @Test
    void testWriteNBT() {
        CompoundTag root = new CompoundTag();
        root.put("name", new StringTag("Bananrama"));
        NamedTag nbt = new NamedTag("hello world", root);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            Serializer.writeNBT(nbt, output);
        } catch (IOException e) {
            fail();
        }

        byte[] expected = {0x0a, 0x00, 0x0b, 0x68, 0x65, 0x6c, 0x6c, 0x6f, 0x20, 0x77, 0x6f, 0x72, 0x6c, 0x64,
                        0x08, 0x00, 0x04, 0x6e, 0x61, 0x6d, 0x65, 0x00, 0x09, 0x42, 0x61, 0x6e, 0x61, 0x6e,
                        0x72, 0x61, 0x6d, 0x61, 0x00};
        assertArrayEquals(expected, output.toByteArray());

    }
}