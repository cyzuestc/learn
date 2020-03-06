package ink.cyz.learn.multiThread.lock;

import org.junit.Test;

public class LockDemo {
    private static volatile int state = 1;
    private static int n = 1;

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lockDemo){
                    if (state!=1){
                        try {
                            lockDemo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int j = 0; j < 5; j++) {
                        System.out.println(Thread.currentThread().getName()+" "+n++);
                    }
                    state = 2;
                    lockDemo.notifyAll();
                }
            }
        },"thread1").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lockDemo){
                    if (state!=2){
                        try {
                            lockDemo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int j = 0; j < 5; j++) {
                        System.out.println(Thread.currentThread().getName()+" "+n++);
                    }
                    state = 3;
                    lockDemo.notifyAll();
                }
            }
        },"thread2").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                synchronized (lockDemo){
                    if (state!=3){
                        try {
                            lockDemo.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    for (int j = 0; j < 5; j++) {
                        System.out.println(Thread.currentThread().getName()+" "+n++);
                    }
                    state = 1;
                    lockDemo.notifyAll();
                }
            }
        },"thread3").start();
    }

    @Test
    public void t(){
        SimpleSpinLock simpleSpinLock = new SimpleSpinLock();
        simpleSpinLock.lock();
        simpleSpinLock.unLock();
    }
}
