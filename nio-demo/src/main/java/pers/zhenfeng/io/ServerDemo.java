package pers.zhenfeng.io;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Grow-Worm
 * @date 2019/04/11
 */
public class ServerDemo {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        System.out.println(inputStream.read());
    }

}
