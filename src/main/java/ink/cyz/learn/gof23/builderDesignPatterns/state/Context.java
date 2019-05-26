package ink.cyz.learn.gof23.builderDesignPatterns.state;

/**
 * DATE: 2019/5/24 22:41
 * AUTHOR: cyz.ink
 **/
public class Context {
    //
    private State state;

    public void setState(State s){
        System.out.println("修改状态：");
        this.state = s;
        state.handle();
    }
}
