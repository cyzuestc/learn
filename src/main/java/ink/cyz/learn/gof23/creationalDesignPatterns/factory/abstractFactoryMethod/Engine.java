package ink.cyz.learn.gof23.creationalDesignPatterns.factory.abstractFactoryMethod;

/**
 * @Date 2019/5/3 20:33
 * @AUTHOR cyz.ink
 **/
public interface Engine {
    void start();
    void run();
}

class LuxuryEngine implements Engine{

    @Override
    public void start() {
        System.out.println("启动快!");
    }

    @Override
    public void run() {
        System.out.println("跑得快!");
    }
}

class CheapEngine implements Engine{

    @Override
    public void start() {
        System.out.println("启动慢");
    }

    @Override
    public void run() {
        System.out.println("跑得慢");
    }
}