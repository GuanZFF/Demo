package pers.zhenfeng.protocol;

import com.google.common.collect.Maps;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

/**
 * @author Grow-Worm
 * @date 2019/09/10
 */
public class DecodeHandle extends ByteToMessageDecoder {

    private static Map<String, Field> map = Maps.newHashMap();

    public DecodeHandle() {
        Field[] fields = Datagram.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            map.putIfAbsent(field.getName(), field);
        }
    }


    @Override

    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        Datagram datagram = new Datagram();

        while (in.isReadable()) {
            if (in.readChar() != 'K') {
                System.out.println("解码错误");
                break;
            }
            int kLen = in.readInt();
            byte[] k = new byte[kLen];
            in.readBytes(k);

            String kName = new String(k);

            in.discardReadBytes();

            if (in.readChar() != 'V') {
                System.out.println("解码错误");
                break;
            }

            int vLen = in.readInt();
            byte[] v = new byte[vLen];
            in.readBytes(v);

            String vValue = new String(v);

            map.get(kName).set(datagram, vValue);

            in.discardReadBytes();
        }

        out.add(datagram);
    }


}
