package ink.cyz.learn.multiThread.lock;

import org.junit.Test;

public class ThreadLocalTest extends Thread{
    private static ThreadLocal<Integer> initValue = ThreadLocal.withInitial(() -> 10);

    @Override
    public void run() {
        int i = 0;
        while (!interrupted()){
            System.out.println(i++);
        }
    }

    @Test
    public void t() throws InterruptedException {
        ThreadLocalTest th = new ThreadLocalTest();
        th.start();
        Thread.sleep(10);
        th.interrupt();
    }
    private static void update(){
        initValue.set(initValue.get()+66);
        System.out.println(initValue.get());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
        new Thread(()->{
            update();
        }).start();
        }
    }
}
