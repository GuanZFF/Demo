package pers.zhenfeng.aio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.Scanner;

/**
 * @author Grow-Worm
 * @date 2019/04/11
 */
public class AioClientDemo {

    private static ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws Exception {
        AsynchronousSocketChannel asynchronousSocketChannel = AsynchronousSocketChannel.open();
        asynchronousSocketChannel.connect(new InetSocketAddress("127.0.0.1", 8888)).get();

        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        while (!data.equals("")) {
            data = scanner.nextLine();
            buffer.put(data.getBytes());
            buffer.flip();
            asynchronousSocketChannel.write(buffer);
            buffer.clear();
        }
    }
}