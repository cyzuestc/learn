package ink.cyz.learn.gof23.creationalDesignPatterns.factory.factoryMethod;

/**
 * @Date 2019/5/3 20:24
 * @AUTHOR cyz.ink
 *
 * 尽管理论建议工厂方法模式,但实际还是使用简单工厂模式
 **/
public class Client {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().createCar();
        Car c2 = new BenzFactory().createCar();
        c1.run();
        c2.run();
    }
}
