package ink.cyz.learn.gof23.builderDesignPatterns.observer;

/**
 * DATE: 2019/5/26 15:06
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        //目标对象
        ConcreteSubject subject = new ConcreteSubject();
        //创建多个对象
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        subject.removeObserver(obs1);
        subject.removeObserver(obs2);
        subject.removeObserver(obs3);

//        改变Subject状态
        subject.setState(3000);

//        看看观察者
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

    }

}
