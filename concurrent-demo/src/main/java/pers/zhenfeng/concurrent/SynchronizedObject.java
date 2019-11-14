package pers.zhenfeng.concurrent;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author Grow-Worm
 * @date 2019/09/21
 */
public class SynchronizedObject {

    public static void main(String[] args) throws Exception {
        Thread.sleep(5000);
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unsafe = (Unsafe) theUnsafe.get(null);

        SynchronizedObject synchronizedObject = new SynchronizedObject();

        System.gc();


        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                synchronized (synchronizedObject) {
                    long aLong = unsafe.getLong(synchronizedObject, 0);

                    System.out.println(Long.toBinaryString(aLong));
                }

                long aLong = unsafe.getLong(synchronizedObject, 0);

                System.out.println(Long.toBinaryString(aLong));
            }).start();
        }

        for (int i = 0; i < 100; i++) {
            synchronized (synchronizedObject) {
                long aLong = unsafe.getLong(synchronizedObject, 0);

                System.out.println(Long.toBinaryString(aLong));
            }
        }

    }

}
