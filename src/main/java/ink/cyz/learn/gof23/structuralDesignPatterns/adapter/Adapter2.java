package ink.cyz.learn.gof23.structuralDesignPatterns.adapter;

/**
 * @Date 2019/5/4 14:25
 * @AUTHOR cyz.ink
 **/
public class Adapter2 implements Target {
    private Adaptee a ;

    public Adapter2(Adaptee a) {
        this.a = a;
    }

    @Override
    public void handleReq() {
        a.request();
    }
}
