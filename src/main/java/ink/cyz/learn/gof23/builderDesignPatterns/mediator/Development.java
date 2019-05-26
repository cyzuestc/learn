package ink.cyz.learn.gof23.builderDesignPatterns.mediator;

/**
 * DATE: 2019/5/24 15:31
 * AUTHOR: cyz.ink
 **/
public class Development implements Department {

    private Mediator m;

    public Development(Mediator m) {
        this.m = m;
        m.registor( "development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心科研，开发项目");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作，没钱了，需要资金");
        m.command(" ");
    }
}
