package nio;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class NewIOMain {
    public static void main(final String[] args){
//        testByteBuffer1();
        testByteBuffer2();
    }

    private static void testByteBuffer2() {
        ByteBuffer buffer1 = ByteBuffer.allocate(10);
        if (buffer1.hasArray())
        {
            System.out.println("buffer1 array: " + buffer1.array());
            System.out.println("Buffer1 array offset: " + buffer1.arrayOffset());
            System.out.println("Capacity: " + buffer1.capacity());
            System.out.println("Limit: " + buffer1.limit());
            System.out.println("Position: " + buffer1.position());
            System.out.println("Remaining: " + buffer1.remaining());
            System.out.println();
        }

        byte[] bytes = new byte[200];
        ByteBuffer buffer2 = ByteBuffer.wrap(bytes);
        buffer2 = ByteBuffer.wrap(bytes, 10, 50);
        if (buffer2.hasArray())
        {
            System.out.println("buffer2 array: " + buffer2.array());
            System.out.println("Buffer2 array offset: " + buffer2.arrayOffset());
            System.out.println("Capacity: " + buffer2.capacity());
            System.out.println("Limit: " + buffer2.limit());
            System.out.println("Position: " + buffer2.position());
            System.out.println("Remaining: " + buffer2.remaining());
        }
    }

    private static void testByteBuffer1() {
        Buffer buffer = ByteBuffer.allocate(7);
        System.out.println("Capacity: " + buffer.capacity());
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());
        System.out.println("Changing buffer limit to 5");
        buffer.limit(5);
        System.out.println("Limit: " + buffer.limit());
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());
        System.out.println("Changing buffer position to 3");
        buffer.position(3);
        System.out.println("Position: " + buffer.position());
        System.out.println("Remaining: " + buffer.remaining());
        System.out.println(buffer);
    }
}
