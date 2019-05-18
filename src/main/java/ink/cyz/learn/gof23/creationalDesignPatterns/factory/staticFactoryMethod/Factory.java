package ink.cyz.learn.gof23.creationalDesignPatterns.factory.staticFactoryMethod;

/**
 * DATE: 2019/5/3 18:04
 * AUTHOR: cyz.ink
 **/
public class Factory {
    public static Car createCar(String type){
        Car c = null;
        if (type.equals("Audi"))c = new Audi();
        else if (type.equals("Benz"))c = new Benz();
        return c;
    }
}
