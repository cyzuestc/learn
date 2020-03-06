package ink.cyz.learn.multiThread.lock;

import org.junit.Test;

public class ThreadDemo {
    public static void t1(Integer a,Integer b){
        synchronized (a){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (b){
            }
        }
    }
    public static void t2(Integer a,Integer b){
        synchronized (b){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (a){

            }
        }
    }

    @Test
    public void t() throws InterruptedException {
        Thread t1 = new Thread(()->{
            ThreadDemo.t1(1,2);
        });
        new Thread(()->{
            ThreadDemo.t1(2,1);
        }).start();
        t1.start();
        t1.join();
    }
    class MyThread extends Thread{
        @Override
        public void run() {
            HelloThread helloThread = new HelloThread();
            helloThread.start();
            try {
                helloThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
        }
    }
    class HelloThread extends Thread{
        @Override
        public void run() {
            int n = 0;
            while (!isInterrupted()){
                System.out.println(n++);
            }
        }
    }
}
