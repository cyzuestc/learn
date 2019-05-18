package ink.cyz.learn.gof23.creationalDesignPatterns.singleton;

import java.io.ObjectStreamException;

/**
 * DATE: 2019/5/3 17:24
 * AUTHOR: cyz.ink
 * 静态内部类实现单例模式
 **/
public class SingletonDemo4 {
    private SingletonDemo4(){

    }
    public static SingletonDemo4 getInstance(){
        return SingletonClassInstance.instance;
    }
    private static class SingletonClassInstance {
         private static final SingletonDemo4 instance = new SingletonDemo4();
    }

    private Object readResolve() throws ObjectStreamException{
        return getInstance();
    }
}
