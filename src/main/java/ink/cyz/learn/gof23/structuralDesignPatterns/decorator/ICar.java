package ink.cyz.learn.gof23.structuralDesignPatterns.decorator;

/**
 * @Date 2019/5/6 22:35
 * @AUTHOR cyz.ink
 *
 * 装饰器模式:IO流,HttpServletRequestWrapper
 **/
public interface ICar {
    void move();
}

//ConcreteComponent
class Car implements ICar{
    @Override
    public void move() {
        System.out.println("陆地上跑");
    }
}

//Decorator
class SuperCar implements ICar{

    protected ICar car;

    public SuperCar(ICar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

//ConcreteDecorator
class FlyCar extends SuperCar{
    public void fly(){
        System.out.println("天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }

    public FlyCar(ICar car) {
        super(car);
    }
}

//ConcreteDecorator
class WaterCar extends SuperCar{
    public void water(){
        System.out.println("WaterCar");
    }

    @Override
    public void move() {
        super.move();
        water();
    }

    public WaterCar(ICar car) {
        super(car);
    }
}

//ConcreteDecorator
class AICar extends SuperCar{
    public AICar(ICar car) {
        super(car);
    }

    public void water(){
        System.out.println("AICar");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }

    public void autoMove() {
        System.out.println("autoMove");
    }
}