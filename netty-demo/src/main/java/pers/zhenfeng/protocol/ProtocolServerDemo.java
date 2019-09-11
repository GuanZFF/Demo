package pers.zhenfeng.protocol;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Grow-Worm
 * @date 2019/09/10
 */
public class ProtocolServerDemo {

    private static final Map<String, NioSocketChannel> socketMap = new ConcurrentHashMap<>(10);

    public static void main(String[] args) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap()
            .group(new NioEventLoopGroup(1), new NioEventLoopGroup())
            .channel(NioServerSocketChannel.class)
            .handler(new ChannelInitializer<NioServerSocketChannel>() {
                @Override
                protected void initChannel(NioServerSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {
                        @Override
                        public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                            NioSocketChannel socketChannel = (NioSocketChannel) msg;
                            System.out.println("客户端注册成功 ID = " + socketChannel.id().asLongText());
                            socketMap.putIfAbsent(socketChannel.id().asLongText(), socketChannel);
                            super.channelRead(ctx, msg);
                        }
                    });
                }
            })
            .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new EncodeHandle());
                    ch.pipeline().addLast(new DecodeHandle());
                    ch.pipeline().addLast(new ServerHandle());
                }
            })
            .option(ChannelOption.SO_BACKLOG, 128)
            .childOption(ChannelOption.SO_KEEPALIVE, true);
        Channel channel = serverBootstrap.bind(8888)
            .addListener(future -> System.out.println("服务启动成功 ID = " + ((ChannelFuture) future).channel().id().asLongText()))
            .channel();

        channel.closeFuture().sync();
    }


    private static void messageSend(String id, String message) {
        NioSocketChannel socketChannel = socketMap.get(id);

    }

}
