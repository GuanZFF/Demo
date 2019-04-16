package pers.zhenfeng.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutionException;

/**
 * @author Grow-Worm
 * @date 2019/04/11
 */
public class AioServerDemo {

    private static String clientName = "客户端";

    private static int index = 1;

    private static ByteBuffer buffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) throws Exception {
        AsynchronousServerSocketChannel asynchronousServerSocketChannel = AsynchronousServerSocketChannel.open();
        asynchronousServerSocketChannel.bind(new InetSocketAddress(8888));

        asynchronousServerSocketChannel.accept(clientName + index++, new CompletionHandler<AsynchronousSocketChannel, String>() {
            @Override
            public void completed(AsynchronousSocketChannel result, String attachment) {
                // 接收连接
                asynchronousServerSocketChannel.accept(clientName + index++, this);
                try {
                    // 处理socket连接
                    channelHandle(result, attachment);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, String attachment) {
                exc.printStackTrace();
            }
        });
        System.in.read();
    }

    private static void channelHandle(AsynchronousSocketChannel result, String attachment) throws ExecutionException, InterruptedException, IOException {
        String data = "-";
        while (!data.equals("")) {
            buffer.clear();
            Integer read = result.read(buffer).get();
            buffer.flip();
            data = new String(buffer.array(), 0, read);
            System.out.println(attachment + " - " + data);
        }
        result.close();
    }

}
