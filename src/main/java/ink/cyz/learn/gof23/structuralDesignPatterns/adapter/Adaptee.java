package ink.cyz.learn.gof23.structuralDesignPatterns.adapter;

/**
 * @Date 2019/5/4 14:20
 * @AUTHOR cyz.ink
 *
 * 被适配的类,相当于例子中的PS/2键盘
 **/
public class Adaptee {

    public void request(){
        System.out.println("可以完成客户请求的需要的功能!");
    }
}
