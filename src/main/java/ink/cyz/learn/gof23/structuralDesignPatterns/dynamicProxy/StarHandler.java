package ink.cyz.learn.gof23.structuralDesignPatterns.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Date 2019/5/4 15:32
 * @AUTHOR cyz.ink
 **/
public class StarHandler implements InvocationHandler {

    Star realStar;

    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        method.invoke(realStar,args);
        return null;
    }
}
