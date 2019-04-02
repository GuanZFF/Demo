package pers.zhenfeng.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Grow-Worm
 * @date 2019/03/27
 */
public class UnsafeDemo {

    private int a;

    private long b;

    private double c;

    public static void main(String[] args) throws Exception {
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        // 证明数据类型在内存中占用的空间，unsafe.objectFieldOffset计算内存地址偏移量
        System.out.println(unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("a")));
        System.out.println(unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("b")));
        System.out.println(unsafe.objectFieldOffset(UnsafeDemo.class.getDeclaredField("c")));
    }

}
