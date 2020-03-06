package ink.cyz.learn.multiThread.lock;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo extends Thread{
    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        set();
    }

    @Test
    public void t() throws InterruptedException {
        ReentrantLockDemo reentrantLockDemo = new ReentrantLockDemo();
        reentrantLockDemo.start();
        Thread.sleep(1000);
    }
    synchronized void  set(){
        lock.lock();
        System.out.println("set");
        get();
        lock.unlock();
    }
    synchronized void get(){
        lock.lock();
        System.out.println(lock.getHoldCount());
        System.out.println("get");
        set();
        lock.unlock();
    }

}
