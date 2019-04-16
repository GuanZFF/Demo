package pers.zhenfeng.io;

import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author Grow-Worm
 * @date 2019/04/11
 */
public class ClientDemo {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8888));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(123);
    }

}
