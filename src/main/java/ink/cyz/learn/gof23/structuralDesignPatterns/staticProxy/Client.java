package ink.cyz.learn.gof23.structuralDesignPatterns.staticProxy;

/**
 * @Date 2019/5/4 15:24
 * @AUTHOR cyz.ink
 *
 * 客户并不知道歌手的真实角色
 **/
public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        ProxyStar proxy = new ProxyStar(real);
        proxy.confer();
        proxy.sing();
        proxy.bootTicket();
        proxy.charge();
        proxy.signContract();
    }
}
