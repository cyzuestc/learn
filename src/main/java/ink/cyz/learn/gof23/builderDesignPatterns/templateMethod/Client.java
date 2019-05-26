package ink.cyz.learn.gof23.builderDesignPatterns.templateMethod;

/**
 * DATE: 2019/5/24 22:01
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoneyTemplateMethod();
        btm.process();
    }
}

