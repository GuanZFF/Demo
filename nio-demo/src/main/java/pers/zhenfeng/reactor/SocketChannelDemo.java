package pers.zhenfeng.reactor;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author Grow-Worm
 * @date 2019/08/23
 */
public class SocketChannelDemo {

    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress(8888));
        socketChannel.configureBlocking(false);

        ByteBuffer buffer = ByteBuffer.allocate(100);

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String message = scanner.next();

            socketChannel.write(ByteBuffer.wrap(message.getBytes()));

            socketChannel.read(buffer);

            buffer.flip();

            System.out.println(new String(buffer.array(), 0, buffer.limit()));

            buffer.clear();
        }
    }

}
