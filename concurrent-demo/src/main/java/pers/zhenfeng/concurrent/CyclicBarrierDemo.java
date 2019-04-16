package pers.zhenfeng.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author Grow-Worm
 * @date 2019/04/16
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3, () -> System.out.println("CyclicBarrierDemo.main"));

        new Thread(() -> {
            try {
                System.out.println("thread1 - start");
                cyclicBarrier.await();
                System.out.println("thread1 - end");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "thread1").start();

        new Thread(() -> {
            try {
                System.out.println("thread2 - start");
                cyclicBarrier.await();
                System.out.println("thread2 - end");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "thread2").start();

        new Thread(() -> {
            try {
                System.out.println("thread3 - start");
                cyclicBarrier.await();
                System.out.println("thread3 - end");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        }, "thread3").start();
    }

}
