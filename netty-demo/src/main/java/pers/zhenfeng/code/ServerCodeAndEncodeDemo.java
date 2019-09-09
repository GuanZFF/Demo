package pers.zhenfeng.code;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * @author Grow-Worm
 * @date 2019/09/08
 */
public class ServerCodeAndEncodeDemo {

    public static void main(String[] args) {
        ServerBootstrap serverBootstrap = new ServerBootstrap()
            .group(new NioEventLoopGroup(1), new NioEventLoopGroup())
            .channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_BACKLOG, 128)
            .childOption(ChannelOption.SO_KEEPALIVE, true)
            .childHandler(new ChannelInitializer<NioSocketChannel>() {
                @Override
                protected void initChannel(NioSocketChannel ch) throws Exception {

                }
            });
    }

}
