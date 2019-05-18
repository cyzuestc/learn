package ink.cyz.learn.gof23.creationalDesignPatterns.prototype;

/**
 * @Date 2019/5/4 12:59
 * @AUTHOR cyz.ink
 *
 * 浅拷贝
 **/
public class Client1 {
    public static void main(String[] args) {
        Sheep s = new Sheep();
        try {
            Sheep s1 = (Sheep) s.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }
}
