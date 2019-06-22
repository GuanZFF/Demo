package pers.zhenfeng.rxjava;

import io.reactivex.Flowable;

/**
 * @author Grow-Worm
 * @date 2019/06/17
 */
public class RXJavaDemo {

    public static void main(String[] args) {
        Flowable.just("Hello world").subscribe(System.out::println);

        Flowable<Integer> filter = Flowable.range(1, 5).map(item -> item * item).filter(item -> item % 2 == 0);

        filter.subscribe(System.out::println);

    }

}
