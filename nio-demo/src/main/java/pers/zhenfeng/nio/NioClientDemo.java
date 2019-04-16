package pers.zhenfeng.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author Grow-Worm
 * @date 2019/04/06
 */
public class NioClientDemo {

    public static void main(String[] args) throws Exception {
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        SocketChannel socketChannel = SocketChannel.open();

        socketChannel.connect(new InetSocketAddress(8888));

        Scanner scanner = new Scanner(System.in);

        String data = scanner.nextLine();

        while (!data.equals("")) {
            System.out.println("your write = " + data);
            buffer.put(data.getBytes());
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
            data = scanner.nextLine();
        }
    }

}
