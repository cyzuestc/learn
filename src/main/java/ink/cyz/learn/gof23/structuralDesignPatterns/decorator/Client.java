package ink.cyz.learn.gof23.structuralDesignPatterns.decorator;

/**
 * @Date 2019/5/6 23:03
 * @AUTHOR cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        Car car = new Car();
        car.move();

        FlyCar flyCar = new FlyCar(car);
        flyCar.move();

        WaterCar waterCar = new WaterCar(car);
        waterCar.move();
        System.out.println("--------");
        AICar aiCar = new AICar(waterCar);
        aiCar.move();
    }
}
