package ink.cyz.learn.gof23.builderDesignPatterns.memento;

/**
 * DATE: 2019/5/26 16:53
 * AUTHOR: cyz.ink
 **/
public class CareTaker {
    private EmpMemento memento;

    public EmpMemento getMemento() {
        return memento;
    }

    public void setMemento(EmpMemento memento) {
        this.memento = memento;
    }

}
