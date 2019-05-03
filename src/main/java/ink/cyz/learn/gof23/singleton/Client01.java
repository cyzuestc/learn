package ink.cyz.learn.gof23.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * DATE: 2019/5/3 17:34
 * AUTHOR: cyz.ink
 **/
public class Client01 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        SingletonDemo4 t1 = SingletonDemo4.getInstance();
        SingletonDemo4 t2 = SingletonDemo4.getInstance();

        System.out.println(t1);
        System.out.println(t2);

        Class<SingletonDemo4> clazz = (Class<SingletonDemo4>) Class.forName("ink.cyz.learn.gof23.singleton.SingletonDemo4");
        Constructor<SingletonDemo4> c = clazz.getDeclaredConstructor(null);
        c.setAccessible(true);
        SingletonDemo4 s2 = c.newInstance();
        SingletonDemo4 s3 = c.newInstance();

        System.out.println(s2);
        System.out.println(s3);


    }
}
