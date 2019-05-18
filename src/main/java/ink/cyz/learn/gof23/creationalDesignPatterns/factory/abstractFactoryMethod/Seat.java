package ink.cyz.learn.gof23.creationalDesignPatterns.factory.abstractFactoryMethod;

/**
 * @Date 2019/5/3 20:36
 * @AUTHOR cyz.ink
 **/
public interface Seat {
    void message();
}

class LuxurySeat implements Seat{

    @Override
    public void message() {
        System.out.println("可以自动按摩的座椅");
    }
}

class CheapSeat implements Seat{

    @Override
    public void message() {
        System.out.println("可以自动按摩的座椅");
    }
}
