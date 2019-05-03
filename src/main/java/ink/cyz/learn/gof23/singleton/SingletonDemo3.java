package ink.cyz.learn.gof23.singleton;

/**
 * @Date 2019/5/3 15:23
 * @AUTHOR cyz.ink
 **/
public class SingletonDemo3 {
    private static SingletonDemo3 instance ;
    private SingletonDemo3(){};
    public static SingletonDemo3 getInstance(){
        if (instance == null){
            SingletonDemo3 s;
            synchronized (SingletonDemo3.class){
                s=instance;
                synchronized (SingletonDemo3.class){
                    if (s == null){
                        s = new SingletonDemo3();
                    }
                }
                instance = s;
            }
        }
        return instance;
    }
}
