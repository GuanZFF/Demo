package pers.zhenfeng.thread;

import java.io.IOException;
import java.util.concurrent.locks.LockSupport;

/**
 * @author Grow-Worm
 * @date 2019/04/14
 */
public class ThreadDemo {

    public static void main(String[] args) throws Exception {

        ThreadDemo threadDemo = new ThreadDemo();

        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                threadDemo.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            LockSupport.park(threadDemo);
            System.out.println("ThreadDemo.main");
        }, "thread - 1");

        new Thread(() -> {
            thread.start();
            try {
//                threadDemo.print();
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            threadDemo.notify();
//            LockSupport.unpark(thread);
        }, "thread - 2").start();

        System.in.read();
    }

    private void print() {
        synchronized (this) {
            System.out.println("ThreadDemo.print");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
