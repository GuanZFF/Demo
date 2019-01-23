package pers.zhenfeng;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.*;

/**
 * @author Grow-Worm
 * @date 2019/01/23
 */
public class NettyHttpServer {

    /**
     * 启动http服务
     *
     * @param port 端口号
     */
    public static void startServer(Integer port) throws InterruptedException {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.channel(NioServerSocketChannel.class);
        NioEventLoopGroup base = new NioEventLoopGroup(1);
        NioEventLoopGroup work = new NioEventLoopGroup(8);
        serverBootstrap.group(base, work);

        serverBootstrap.childHandler(new ChannelInitializer<NioSocketChannel>() {

            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                nioSocketChannel.pipeline().addLast("http-decode", new HttpRequestDecoder());
                nioSocketChannel.pipeline().addLast("http-encode", new HttpResponseEncoder());
                nioSocketChannel.pipeline().addLast("servlet", new HttpServletHandle());
            }

        });

        ChannelFuture f = serverBootstrap.bind(port).sync();
        System.out.println("服务开启");
        f.channel().closeFuture().sync();
    }

    static class HttpServletHandle extends SimpleChannelInboundHandler {

        @Override
        protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
            DefaultFullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/html;charset=utf-8");
            response.content().writeBytes("test".getBytes());
            channelHandlerContext.writeAndFlush(response).addListener(ChannelFutureListener.CLOSE);
        }

    }

    public static void main(String[] args) {
        try {
            startServer(8080);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
