package ink.cyz.learn.gof23.builderDesignPatterns.command;

/**
 * DATE: 2019/5/24 17:14
 * AUTHOR: cyz.ink
 **/
public class Invoke {
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    public void call(){
        command.execute();
    }
}
