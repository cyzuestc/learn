package ink.cyz.learn.gof23.builderDesignPatterns.state;

/**
 * DATE: 2019/5/24 22:40
 * AUTHOR: cyz.ink
 **/
public class CheckedInState implements State {

    @Override
    public void handle() {
        System.out.println("房间已经入住");
    }
}
