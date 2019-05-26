package ink.cyz.learn.gof23.builderDesignPatterns.strategy;

/**
 * DATE: 2019/5/24 21:48
 * AUTHOR: cyz.ink
 **/
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void printprice(double s){
        System.out.println(strategy.getPrice(s));
    }
}
