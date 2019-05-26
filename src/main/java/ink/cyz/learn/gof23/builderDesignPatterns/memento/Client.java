package ink.cyz.learn.gof23.builderDesignPatterns.memento;

/**
 * DATE: 2019/5/26 16:54
 * AUTHOR: cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        CareTaker taker = new CareTaker();
        Emp emp = new Emp("1",11,111);
        System.out.println(emp.toString());
        taker.setMemento(emp.memento());//备忘一次
        emp.setAge(1111);
        emp.recovery(taker.getMemento());
        System.out.println(emp);
    }


}
