package ink.cyz.learn.gof23.creationalDesignPatterns.factory.abstractFactoryMethod;

/**
 * @Date 2019/5/3 20:42
 * @AUTHOR cyz.ink
 **/
public interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("转得快");
    }
}

class CheapTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("转得慢");
    }
}
