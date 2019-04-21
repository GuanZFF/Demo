package pers.zhenfeng.design.pattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Grow-Worm
 * @date 2019/04/20
 */
public class Subject {

    private List<Observer> observers = new ArrayList<>();

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void publish(int state) {
        setState(state);
        notifyObserver();
    }

    private void notifyObserver() {
        observers.forEach(Observer::update);
    }

}
