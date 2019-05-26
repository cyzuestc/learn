package ink.cyz.learn.gof23.builderDesignPatterns.state;

/**
 * DATE: 2019/5/24 22:39
 * AUTHOR: cyz.ink
 **/
public class FreeState implements State{

    @Override
    public void handle() {
        System.out.println("房间空闲！");
    }
}
