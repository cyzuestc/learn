package ink.cyz.learn.gof23.builderDesignPatterns.observerUtil;


/**
 * DATE: 2019/5/26 16:24
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();

        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        subject.set(5);

    }

}
