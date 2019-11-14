package pers.zhenfeng.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Grow-Worm
 * @date 2019/09/21
 */
public class ConditionObjectDemo {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock(true);

        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();

            System.out.println("1");

            try {

                condition.await();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("2");

            lock.unlock();

        }).start();


        new Thread(() -> {
            lock.lock();

            System.out.println("3");

            condition.signal();

            System.out.println("4");

            lock.unlock();
        }).start();


    }

}
