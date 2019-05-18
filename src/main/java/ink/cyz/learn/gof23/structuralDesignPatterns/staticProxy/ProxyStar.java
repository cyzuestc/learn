package ink.cyz.learn.gof23.structuralDesignPatterns.staticProxy;

/**
 * @Date 2019/5/4 15:22
 * @AUTHOR cyz.ink
 **/
public class ProxyStar implements Star {

    Star realStar ;

    public ProxyStar(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar.confer");
    }

    @Override
    public void signContract() {
        System.out.println("ProxyStar.signContract");
    }

    @Override
    public void bootTicket() {
        System.out.println("ProxyStar.bootTicket");
    }

    @Override
    public void sing() {
        realStar.sing();
    }

    @Override
    public void charge() {
        System.out.println("ProxyStar.charge");
    }
}
