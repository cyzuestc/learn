package ink.cyz.learn.gof23.builderDesignPatterns.command;

/**
 * DATE: 2019/5/24 17:11
 * AUTHOR: cyz.ink
 **/
public interface Command {
    void execute();
}

class ConcreteCommand implements Command{

//    命令的执行者
    private Receiver r;

    public ConcreteCommand(Receiver r) {
        this.r = r;
    }

    @Override
    public void execute() {
        //命令前后，执行相关处理

        r.action();
    }
}