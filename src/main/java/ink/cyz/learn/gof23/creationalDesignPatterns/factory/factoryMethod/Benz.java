package ink.cyz.learn.gof23.creationalDesignPatterns.factory.factoryMethod;

/**
 * DATE: 2019/5/3 18:03
 * AUTHOR: cyz.ink
 **/
public class Benz implements Car {

    @Override
    public void run() {
        System.out.println("Benz在奔跑");
    }
}
