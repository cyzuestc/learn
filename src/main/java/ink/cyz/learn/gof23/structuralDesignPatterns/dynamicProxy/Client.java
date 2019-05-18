package ink.cyz.learn.gof23.structuralDesignPatterns.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * @Date 2019/5/6 20:55
 * @AUTHOR cyz.ink
 **/
public class Client {
    public static void main(String[] args) {
        Star readStar = new RealStar();
        StarHandler handler = new StarHandler(readStar);
        Star prox = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{Star.class},handler);
        prox.bootTicket();


    }
}
