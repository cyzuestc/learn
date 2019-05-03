package ink.cyz.learn.gof23.singleton;

/**
 * @Date 2019/5/3 15:23
 * @AUTHOR cyz.ink
 **/
public class SingletonDemo3 {
    private static SingletonDemo3 instance ;
    private SingletonDemo3(){};

    public static SingletonDemo3 getInstanceWrong(){
        if (instance == null){
            //此时可能有多个线程进入,创建s对象
            SingletonDemo3 s;
            //多个对象先后创建实例对象
            synchronized (SingletonDemo3.class){s = new SingletonDemo3();}
                instance = s;
        }
        return instance;
    }

    public static SingletonDemo3 getInstance(){
        if (instance == null){
            //此时可能有多个线程进入,创建s对象
            SingletonDemo3 s;
            //只有一个线程进入synchronized
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
