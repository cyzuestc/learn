package ink.cyz.learn.gof23.builderDesignPatterns.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * DATE: 2019/5/26 14:59
 * AUTHOR: cyz.ink
 **/
public class Subject {
    protected List<Observer> list = new ArrayList<>();
    public void register(Observer observer){
        list.add(observer);
    }
    public void removeObserver(Observer obs){
        list.remove(obs);
    }
    //通知所有的观察者
    public void notifyAllObservers(){
        for (Observer o : list){
            o.update(this);
        }
    }

}
