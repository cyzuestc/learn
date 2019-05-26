package ink.cyz.learn.gof23.builderDesignPatterns.templateMethod;

/**
 * DATE: 2019/5/24 22:00
 * AUTHOR: cyz.ink
 **/
public class DrawMoneyTemplateMethod extends BankTemplateMethod {

    @Override
    public void transact() {
        System.out.println("提取1000块");
    }
}
