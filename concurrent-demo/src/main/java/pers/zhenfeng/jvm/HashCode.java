package pers.zhenfeng.jvm;

/**
 * @author Grow-Worm
 * @date 2019/09/28
 */
public class HashCode {

    public static void main(String[] args) {

        HashCode hashCode1 = new HashCode();

        HashCode hashCode2 = new HashCode();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                synchronized (hashCode1) {
                    System.out.println("123 - " + Thread.currentThread().getName());
                    sleep();
                }
            }, "thread-1-" + i).start();
        }

        sleep();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                synchronized (hashCode2) {
                    System.out.println("456 - " + Thread.currentThread().getName());
                    sleep();
                }
            }, "thread-2-" + i).start();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
