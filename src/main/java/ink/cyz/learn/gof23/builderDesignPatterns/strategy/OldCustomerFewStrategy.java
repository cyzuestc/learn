package ink.cyz.learn.gof23.builderDesignPatterns.strategy;

/**
 * DATE: 2019/5/24 21:47
 * AUTHOR: cyz.ink
 **/
public class OldCustomerFewStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打8折");
        return standardPrice*0.8;
    }
}
