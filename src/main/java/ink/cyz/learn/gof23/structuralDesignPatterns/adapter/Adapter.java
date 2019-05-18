package ink.cyz.learn.gof23.structuralDesignPatterns.adapter;

/**
 * @Date 2019/5/4 14:25
 * @AUTHOR cyz.ink
 **/
public class Adapter extends Adaptee implements Target {
    @Override
    public void handleReq() {
        this.request();
    }
}
