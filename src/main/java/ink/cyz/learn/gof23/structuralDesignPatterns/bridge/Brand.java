package ink.cyz.learn.gof23.structuralDesignPatterns.bridge;

/**
 * 电脑品牌的维度
 */
public interface Brand {
    void sale();
}

class Lenovo implements Brand{
    @Override
    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand{
    @Override
    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}

