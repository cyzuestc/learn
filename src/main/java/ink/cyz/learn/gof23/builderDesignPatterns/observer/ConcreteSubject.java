package ink.cyz.learn.gof23.builderDesignPatterns.observer;

/**
 * DATE: 2019/5/26 15:03
 * AUTHOR: cyz.ink
 **/
public class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }
}
