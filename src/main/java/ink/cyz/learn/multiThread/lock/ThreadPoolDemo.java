package ink.cyz.learn.multiThread.lock;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDemo {

    @Test
    public void t(){
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 1000; i++) {
            executor.submit(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        executor.shutdown();

    }

}
