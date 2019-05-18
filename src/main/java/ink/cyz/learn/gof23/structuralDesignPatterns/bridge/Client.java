package ink.cyz.learn.gof23.structuralDesignPatterns.bridge;

/**
 * @Date 2019/5/6 21:32
 * @AUTHOR cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        Computer c = new Laptop(new Lenovo());
        c.sale();
    }
}
