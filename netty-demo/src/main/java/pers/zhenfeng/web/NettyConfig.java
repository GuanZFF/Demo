package pers.zhenfeng.web;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * 存储整个工程的全局配置
 */
public class NettyConfig {

    //存储每一个客户端接入进来时的channel对象
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    // 每一个组占用一个group
    public static Map<String, ChannelGroup> channelGroupMap = new HashMap<>();

    /**
     * 生成一个channel对象
     *
     * @param key 对象key值
     */
    public static void generateChannelGroup(String key) {
        channelGroupMap.put(key, new DefaultChannelGroup(GlobalEventExecutor.INSTANCE));
    }
}
