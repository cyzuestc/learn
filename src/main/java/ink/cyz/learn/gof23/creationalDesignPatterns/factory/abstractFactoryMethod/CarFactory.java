package ink.cyz.learn.gof23.creationalDesignPatterns.factory.abstractFactoryMethod;

/**
 * @Date 2019/5/3 20:43
 * @AUTHOR cyz.ink
 **/
public interface CarFactory {
    Engine createEngine();
    Tyre createTyre();
    Seat createSeat();

}
