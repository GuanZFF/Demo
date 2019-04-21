package pers.zhenfeng.design.pattern.observer;

/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public abstract class Observer {

    protected Subject subject;

    protected abstract void update();
}
