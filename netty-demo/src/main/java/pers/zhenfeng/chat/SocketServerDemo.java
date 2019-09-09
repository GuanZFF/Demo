package pers.zhenfeng.chat;

import com.google.common.collect.Maps;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * @author Grow-Worm
 * @date 2019/09/05
 */
public class SocketServerDemo {

    private static Map<String, NioSocketChannel> channelMap = Maps.newHashMap();


    public static void main(String[] args) throws Exception {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup work = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, work);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.option(ChannelOption.SO_BACKLOG, 128);
        bootstrap.handler(new ChannelInboundHandlerAdapter() {

            @Override
            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                NioSocketChannel socketChannel = (NioSocketChannel) msg;
                System.out.println("custom register. id = " + socketChannel.id().asLongText());
                channelMap.put(socketChannel.id().asLongText(), socketChannel);

                super.channelRead(ctx, msg);
            }

        });
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel ch) throws Exception {
                ch.pipeline().addLast(new ChannelInboundHandlerAdapter() {

                    @Override
                    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                        System.out.println("receive message");
                        ctx.channel().writeAndFlush(Unpooled.copiedBuffer("OK".getBytes()));

                        ByteBuf buf = (ByteBuf) msg;
                        String message = buf.toString(Charset.forName("UTF-8"));

                        super.channelRead(ctx, msg);
                        sendSocketMessage(ctx.channel().id().asLongText(), message);
                    }

                    @Override
                    public void channelUnregistered(ChannelHandlerContext ctx) throws Exception {
                        channelMap.remove(ctx.channel().id().asLongText());
                        System.out.println("custom leave. id = " + ctx.channel().id().asLongText());
                        super.channelUnregistered(ctx);
                    }
                }).addLast(new ChannelOutboundHandlerAdapter() {
                    @Override
                    public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
                        System.out.println("send message to " + ctx.channel().id().asLongText());
                        super.write(ctx, msg, promise);
                    }
                });
            }
        });

        ChannelFuture sync = bootstrap.bind(8888).addListener(future -> {
            ChannelFuture channelFuture = (ChannelFuture) future;
            System.out.println("服务启动成功ID = " + channelFuture.channel().id().asLongText());
        }).sync();
        sync.channel().closeFuture().sync();
    }

    private static void sendSocketMessage(String currentKey, String msg) {

        channelMap.forEach((key, value) -> {
            if (key.equals(currentKey)) {
                return;
            }
            value.pipeline().writeAndFlush(Unpooled.copiedBuffer(msg.getBytes()));
        });
    }

}
