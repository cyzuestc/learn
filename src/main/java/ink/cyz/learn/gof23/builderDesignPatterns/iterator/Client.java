package ink.cyz.learn.gof23.builderDesignPatterns.iterator;

/**
 * DATE: 2019/5/23 17:51
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        ConcreteMyAggregate cma = new ConcreteMyAggregate();
        cma.addObject("aa");
        cma.addObject("bb");
        cma.addObject("cc");
        cma.addObject("dd");
        cma.addObject("ee");
        MyIterator iter = cma.createIterator();
        while (iter.hasNext()){
            System.out.println(iter.getCurrentObj());
            iter.next();
        }
    }
}
