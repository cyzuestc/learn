package ink.cyz.learn.gof23.builderDesignPatterns.observerUtil;

import java.util.Observable;
import java.util.Observer;

/**
 * DATE: 2019/5/26 16:17
 * AUTHOR: cyz.ink
 **/
public class ObserverA implements Observer {
    private int myState;
    @Override
    public void update(Observable o, Object arg) {
        myState = ((ConcreteSubject)o).getState();
        System.out.println(myState);
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
