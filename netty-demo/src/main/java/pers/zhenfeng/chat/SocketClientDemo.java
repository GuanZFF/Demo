package pers.zhenfeng.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * @author Grow-Worm
 * @date 2019/09/05
 */
public class SocketClientDemo {

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap()
            .group(new NioEventLoopGroup())
            .channel(NioSocketChannel.class)
            .handler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {

                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {

                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            System.out.println("receive message");
                            ByteBuf buf = (ByteBuf) msg;
                            System.out.println(buf.toString(Charset.forName("UTF-8")));
                            super.channelRead(ctx, msg);
                        }

                    });
                }
            });
        Channel channel = bootstrap.connect(new InetSocketAddress(8888)).channel();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            if (s.equals("over")) {
                break;
            }

            channel.writeAndFlush(Unpooled.copiedBuffer(s.getBytes()));
        }

        channel.closeFuture().sync();
    }

}
