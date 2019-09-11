package pers.zhenfeng.protocol;

import com.alibaba.fastjson.JSON;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Grow-Worm
 * @date 2019/09/10
 */
public class ServerHandle extends SimpleChannelInboundHandler<Datagram> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Datagram msg) throws Exception {
        System.out.println(JSON.toJSONString(msg));
    }

}
