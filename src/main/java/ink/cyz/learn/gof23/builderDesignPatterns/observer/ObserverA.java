package ink.cyz.learn.gof23.builderDesignPatterns.observer;

/**
 * DATE: 2019/5/26 15:04
 * AUTHOR: cyz.ink
 **/
public class ObserverA implements Observer {

    private int myState;

    @Override
    public void update(Subject subject) {
        myState = ((ConcreteSubject)subject).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
