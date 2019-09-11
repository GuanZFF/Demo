package pers.zhenfeng.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

import java.lang.reflect.Field;

/**
 * @author Grow-Worm
 * @date 2019/09/10
 */
public class EncodeHandle extends MessageToByteEncoder<Datagram> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Datagram msg, ByteBuf out) throws Exception {
        Field[] declaredFields = msg.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);

            String name = field.getName();
            out.writeChar('K').writeInt(name.length()).writeBytes(name.getBytes());

            Object fieldObject = field.get(msg);
            out.writeChar('V');
            if (fieldObject == null) {
                out.writeByte(0);
            } else {
                String k = (String) fieldObject;
                out.writeInt(k.length()).writeBytes(k.getBytes());
            }
        }
    }

}
