package ink.cyz.learn.gof23.builderDesignPatterns.observerUtil;

import java.util.Observable;

/**
 * DATE: 2019/5/26 15:54
 * AUTHOR: cyz.ink
 **/
//目标对象
public class ConcreteSubject extends Observable {
    private int state;
    public void set(int s){
        state = s;
        setChanged();
        notifyObservers(state);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
