package pers.zhenfeng.protocol;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author Grow-Worm
 * @date 2019/09/10
 */
public class ProtocolClientDemo {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap()
            .group(new NioEventLoopGroup())
            .channel(NioSocketChannel.class)
            .option(ChannelOption.SO_KEEPALIVE, true)
            .handler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EncodeHandle());
                    ch.pipeline().addLast(new DecodeHandle());
                    ch.pipeline().addLast(new ClientHandle());
                }
            });

        Channel channel = bootstrap
            .connect(new InetSocketAddress(8888))
            .addListener(future -> System.out.println("连接成功"))
            .channel();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equals("over")) {
                break;
            }

            Datagram datagram = new Datagram();
            datagram.setUsername("guanzhenfeng");
            datagram.setPassword("1234567890");
            datagram.setAge("34");

            channel.writeAndFlush(datagram);
        }

        channel.closeFuture().sync();
    }

}
