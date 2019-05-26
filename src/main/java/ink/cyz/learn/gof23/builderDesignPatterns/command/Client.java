package ink.cyz.learn.gof23.builderDesignPatterns.command;

/**
 * DATE: 2019/5/24 17:22
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        Command c = new ConcreteCommand(new Receiver());
        Invoke i = new Invoke(c);
        i.call();
    }

}
