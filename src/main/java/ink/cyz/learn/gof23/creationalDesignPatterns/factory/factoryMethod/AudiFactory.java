package ink.cyz.learn.gof23.creationalDesignPatterns.factory.factoryMethod;

/**
 * @Date 2019/5/3 20:22
 * @AUTHOR cyz.ink
 **/
public class AudiFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
