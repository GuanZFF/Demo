package pers.zhenfeng.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author Grow-Worm
 * @date 2019/09/11
 */
public class TestBuf {

    public static void main(String[] args) {
        ByteBuf buf = Unpooled.copiedBuffer("1234".getBytes());

        buf.readChar();

        byte[] b = new byte[2];

        buf.readBytes(b);

        System.out.println(buf);
    }

}
