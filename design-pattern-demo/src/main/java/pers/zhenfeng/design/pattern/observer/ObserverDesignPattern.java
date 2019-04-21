package pers.zhenfeng.design.pattern.observer;

/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public class ObserverDesignPattern {

    public static void main(String[] args) {
        Subject subject = new Subject();
        new BinaryObserver(subject);
        subject.publish(2);
    }

}
