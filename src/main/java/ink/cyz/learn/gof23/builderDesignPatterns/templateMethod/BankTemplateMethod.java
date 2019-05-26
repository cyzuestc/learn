package ink.cyz.learn.gof23.builderDesignPatterns.templateMethod;

/**
 * DATE: 2019/5/24 21:59
 * AUTHOR: cyz.ink
 **/
public abstract class BankTemplateMethod {
    public void takeNumber(){
        System.out.println("取号排队");
    }
    public abstract void transact();

    public void evaluate(){
        System.out.println("反馈评分");
    }

    public final void process(){
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}
