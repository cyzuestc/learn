package ink.cyz.learn.gof23.creationalDesignPatterns.factory.abstractFactoryMethod;

/**
 * @Date 2019/5/3 20:46
 * @AUTHOR cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        CarFactory carFactory = new LuxuryCarFactory();
        Engine e = carFactory.createEngine();
        e.run();
        e.start();
    }
}
