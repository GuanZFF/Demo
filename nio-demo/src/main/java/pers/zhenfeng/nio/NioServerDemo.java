package pers.zhenfeng.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Grow-Worm
 * @date 2019/04/06
 */
public class NioServerDemo {

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);

        Selector selector = Selector.open();

        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ByteBuffer buffer = ByteBuffer.allocate(1024);

        while (selector.select() > 0) {
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                // 客户端请求连接
                if (selectionKey.isAcceptable()) {
                    System.out.println("注册一个Channel到selector");
                    ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
                    channel.accept().configureBlocking(false).register(selector, SelectionKey.OP_READ);
                }

                // 读数据
                if (selectionKey.isReadable()) {
                    SocketChannel channel = (SocketChannel) selectionKey.channel();
                    buffer.clear();
                    int read = channel.read(buffer);
                    buffer.flip();
                    System.out.println("read = " + new String(buffer.array(), 0, read));
                    selectionKey.interestOps(SelectionKey.OP_READ);
                }

                // 写数据
                if (selectionKey.isWritable()) {
                    selectionKey.interestOps(SelectionKey.OP_READ);
                }

                iterator.remove();
            }
        }
    }



}
