package ink.cyz.learn.gof23.singleton;
/**
 * @Date 2019/5/3 15:13
 * @AUTHOR cyz.ink
 * 单例:
 * 饿汉式,懒汉式,双重检查式,静态内部类,枚举单例
 *
 * 饿汉式
 **/
public class SingletonDemo1 {
    private static  SingletonDemo1 s =new SingletonDemo1();
    private SingletonDemo1(){}
    /*
    虚拟机只会加载一次该类,所以synchronized不需要
     */
    public static /*synchronized*/ SingletonDemo1 getInstance(){
        return s;
    }
}
