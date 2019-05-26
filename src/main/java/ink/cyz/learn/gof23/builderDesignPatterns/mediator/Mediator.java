package ink.cyz.learn.gof23.builderDesignPatterns.mediator;

public interface Mediator {
    void registor(String dname,Department d);
    void command(String dname);
}
