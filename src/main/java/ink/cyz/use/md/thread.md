看这篇文章
https://www.cnblogs.com/wxd0108/p/5479442.html

#引
- 进程: 一段程序关于某个数据集合的一次运行活动.在传统的操作系统中,进程既是基本的分配单元,也是基本的执行单元.
进程是一段实体,有自己的地址空间,进程的三种状态:就绪,运行,阻塞.
- 线程: 线程可以利用进程所拥有的资源.在引入线程的操作系统中,通常把进程作为分配资源的基本单位,而把线程作为独立运行和
独立调度的基本单位.
- 多线程: 指一个进程运行时产生了多个线程.
- 进程与线程: 一个进程崩溃后,在保护模式下不会对其他进程产生影响.一个线程死掉就等于整个进程死掉.
- 并行: 多个CPU共同执行一段逻辑
- 并发: 通过CPU调度方法,让用户看上去同时执行,实际从cpu操作层面不是同时.

# 扎好马步: 线程的状态
A thread can be in one of the following states.
- New 
- Runnable
- Blocked
- Waiting
- Timed_waiting
- Terminated
# 内功心法: 每个对象都有的方法(机制)
synchronized,wait,notify是任何对象都有的同步工具
- monitor
Java中每个对象都有一个监视器,来监测并发代码的重入.在多线程编码时该监视器不发挥作用,
反之如果在synchronized范围内,监视器发挥作用.
wait/notify必须存在于synchronized块中,并且这三个关键字针对的同一个监视器.
这意味着wait之后,其他线程可以进入同步块执行.
- synchronized
代码块:如下,在多线程环境下,synchronized块中的方法获取了lock实例的
monitor,如果实例相同,那么只有一个线程能执行该块内容.
```
public class Thread1 implements Runnable{
    Object lock;
    public void run(){
        synchronized(lock){
            ..do something;
        }
    }

}
```
直接用于方法:获取类实例的monitor,如果修饰的是static,则锁定该类所有实例.
```
public class Thread1 implements Runnable{
    public synchronized void run(){
        ..do something
    }
}
```
synchronized,wait,notify结合:典型场景 生产者消费者问题
```
public synchronized void produce(){
    if(this.product >= MAX_PRODUCT){
        try{
            wait();
            System.out.println("产品已满,请稍后再生产");
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return;
    }
    this.product++;
    //通知等待区的消费者可以取出产品了
    notifyAll();
}

//消费者取产品
public synchronized void comsume(){
    if(this.product <= MIN_PRODUCT){
        try{
            //缺货,稍后再取
            wait();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        return;
    }
    this.product--;
    //通知生产者可以生产了
    notifyAll();
}
```
- volatile

1. volatile:不稳定的,易变的

2. 多线程的内存模型:main memory,working memory,在处理数据时,线程吧至从主存中load到本地栈,
完成操作后save回去,volatile将每次针对该变量的操作都激发一次load and save.

3. 如果针对多线程使用的变量不是volatile/final修饰的,很可能会产生不可预知的后果.(比如另一个线程修改了这个值,
之前的线程可能会看到修改前的值).
其实道理上同一个实例的同一属性本身只有一个副本,但多线程会缓存值.本质上,volatile就不会缓存,直接取值.

4. volatile会禁止指令重排.
5. volatile具有可见性,有序性,但不具有原子性.这是与synchronized,java.util.concurrent.locks.Lock的最大功能差异.
6. 适用于读多写少,不会让线程阻塞,响应速度快.

# 太祖长拳: 基本线程类
基本线程类指的是Thread,Runnable,Callable.

- Thread类相关方法
1. yield: 当前线程转让cpu控制权,让别的就绪状态线程运行
2. sleep: 暂停一段时间
3. join: 在某线程调用other.join(),将等待other执行完后才继续本线程
4. interrupt:将中断标识设为true而非中断一个线程
- Runnable 
与Thread类似
- Callable
Future模式:并发模式的一种,其中Future对象用来存放该线程的返回值及状态
# 九阴真经: 高级多线程控制类
以上是内功心法,接下来是实际项目中常用到的工具了.Java1.5提供了一个非常高效实用的多线程包:
java.util.concurrent,提供了大量高级工具.
1. ThreadLocal类
用处:保存线程的独立变量.
每一个Thread都持有一个ThreadLocal类型的变量,该类是一个轻量型的map,维护一个本地map.
2. 原子类AtomicInteger,AtomicBoolean...
使用自己保证原子的操作,等同于synchronzied
```
AtomicInteger.compareAndSet(int expect,int update)
该方法可以用于乐观锁,
```
3. Lock类
Lock更加灵活,可以自由定义加锁解锁的顺序.提供多种加锁方案.(lock阻塞式,trylock无阻塞式).
本质上和synchronized是一样的.
- ReentrantLock
4. 容器类
BlockingQueue
ConcurrentHashMap
5. 管理类
ThreadPoolExecutor
内部逻辑为:
1. 当有任务提交的时候，会创建核心线程去执行任务（即使有核心线程空闲仍会创建）；
2. 当核心线程数达到corePoolSize时，后续提交的都会进BlockingQueue中排队；
3. 当BlockingQueue满了(offer失败)，就会创建临时线程(临时线程空闲超过一定时间后，会被销毁)；
4. 当线程总数达到maximumPoolSize时，后续提交的任务都会被RejectedExecutionHandler拒绝。
```

```

