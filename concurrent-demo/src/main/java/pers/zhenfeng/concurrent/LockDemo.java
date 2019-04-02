package pers.zhenfeng.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Grow-Worm
 * @date 2019/03/27
 */
public class LockDemo implements Runnable {

    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Executor executor = Executors.newFixedThreadPool(10);
        executor.execute(new LockDemo(lock, "thread1"));
        executor.execute(new LockDemo(lock, "thread2"));
    }

    private ReentrantLock lock;

    private String threadName;

    public LockDemo(ReentrantLock lock, String threadName) {
        this.lock = lock;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        lock.lock();
        System.out.println(threadName);
        lock.unlock();
    }
}
