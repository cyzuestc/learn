package ink.cyz.learn.gof23.creationalDesignPatterns.factory.abstractFactoryMethod;

/**
 * @Date 2019/5/3 20:45
 * @AUTHOR cyz.ink
 **/
public class LuxuryCarFactory implements CarFactory{

    @Override
    public Engine createEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Tyre createTyre() {
        return new LuxuryTyre();
    }

    @Override
    public Seat createSeat() {
        return new LuxurySeat();
    }
}
