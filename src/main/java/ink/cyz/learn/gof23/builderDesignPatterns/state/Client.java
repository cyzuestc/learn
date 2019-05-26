package ink.cyz.learn.gof23.builderDesignPatterns.state;

/**
 * DATE: 2019/5/24 22:43
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        Context ctx = new Context();
        ctx.setState(new FreeState());
        ctx.setState(new BookedState());

    }
}
