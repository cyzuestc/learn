package ink.cyz.learn.gof23.creationalDesignPatterns.factory.staticFactoryMethod;

/**
 * DATE: 2019/5/3 18:03
 * AUTHOR: cyz.ink
 **/
public class Audi implements Car {

    @Override
    public void run() {
        System.out.println("Audi在奔跑");
    }
}
