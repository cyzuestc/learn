package ink.cyz.learn.gof23.creationalDesignPatterns.factory.staticFactoryMethod;

/**
 * DATE: 2019/5/3 17:59
 * AUTHOR: cyz.ink
 *
 * 简单工厂模式>静态工厂模式,对新加产品无能为力,只能返回现有产品
 **/
public class Client {
    public static void main(String[] args) {
        Car c1 = Factory.createCar("Audi");
        Car c2 = Factory.createCar("Benz");
        c1.run();
        c2.run();
    }
}
