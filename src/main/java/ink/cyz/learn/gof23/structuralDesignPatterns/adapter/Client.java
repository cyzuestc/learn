package ink.cyz.learn.gof23.structuralDesignPatterns.adapter;

/**
 * @Date 2019/5/4 14:23
 * @AUTHOR cyz.ink
 *
 * 相当于例子中笔记本,只有USB接口
 **/
public class Client {

    public void test1(Target t){
        t.handleReq();
    }

    public static void main(String[] args) {
        //只有USB接口的电脑
        Client c = new Client();
        //PS/2的键盘
        Adaptee a = new Adaptee();
        //适配器
        Target t = new Adapter();
        c.test1(t);
    }
}
