package ink.cyz.learn.gof23.singleton;

/**
 * @Date 2019/5/3 15:13
 * @AUTHOR cyz.ink
 *
 * 懒汉式,对象延迟加载,每次使用都要加锁同步,效率较低
 **/
public class SingletonDemo2 {
    private static SingletonDemo2 s;
    private SingletonDemo2(){};
    public static synchronized SingletonDemo2 getInstance(){
        if (s == null){
            s = new SingletonDemo2();
        }
        return s;
    }
}
