package pers.zhenfeng.design.pattern.observer;

/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    protected void update() {
        System.out.println(this.subject.getState());
        System.out.println("BinaryObserver.update");
    }

}
