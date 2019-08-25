package pers.zhenfeng.reactor;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Grow-Worm
 * @date 2019/08/23
 */
public class ServerSocketChannelDemo {

    public static void main(String[] args) throws Exception {

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(100);

        System.out.println("accept ...");

        while (!Thread.currentThread().isInterrupted()) {
            int select = selector.select();
            if (select == 0) {
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();

            while (iterator.hasNext()) {
                SelectionKey key = iterator.next();
                if (key.isAcceptable()) {
                    System.out.println("accept ...");
                    iterator.remove();

                    ServerSocketChannel serverSocketChannel1 = (ServerSocketChannel) key.channel();

                    SocketChannel socketChannel = serverSocketChannel1.accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if (key.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    socketChannel.read(buffer);

                    buffer.flip();

                    System.out.println(new String(buffer.array(), 0, buffer.limit()));

                    buffer.clear();

                    socketChannel.register(selector, SelectionKey.OP_WRITE);
                }
                if (key.isWritable()) {
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    socketChannel.write(ByteBuffer.wrap("I received your message".getBytes()));

                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
                if (key.isConnectable()) {
                    System.out.println("connect ...");
                }
            }

        }

    }

}
