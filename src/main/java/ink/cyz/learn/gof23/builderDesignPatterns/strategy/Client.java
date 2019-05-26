package ink.cyz.learn.gof23.builderDesignPatterns.strategy;

/**
 * DATE: 2019/5/24 21:51
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        Strategy s1 = new OldCustomerLargeStrategy();
        Context context = new Context(s1);
        context.printprice(100);
    }

}
