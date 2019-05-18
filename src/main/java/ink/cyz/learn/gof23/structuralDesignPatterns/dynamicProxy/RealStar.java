package ink.cyz.learn.gof23.structuralDesignPatterns.dynamicProxy;

/**
 * @Date 2019/5/4 15:21
 * @AUTHOR cyz.ink
 **/
public class RealStar implements Star {
    @Override
    public void confer() {
        System.out.println("RealStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("RealStar.signContract");
    }

    @Override
    public void bootTicket() {
        System.out.println("RealStar.bootTicket");
    }

    @Override
    public void sing() {
        System.out.println("RealStar.sing");
    }

    @Override
    public void charge() {
        System.out.println("RealStar.charge");
    }
}
