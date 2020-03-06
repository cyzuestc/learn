package ink.cyz.learn.multiThread.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CopyOnWriteDemo {
    @Test
    public void t() throws InterruptedException {
        CopyOnWriteArrayList list = new CopyOnWriteArrayList();
//        List list = new ArrayList();
        ExecutorService service = Executors.newCachedThreadPool();
        for (int i = 0; i < 5000; i++) {
            service.submit(()->{
                for (int j = 0; j < 5; j++) {
                    list.add(j);
                }
            });
        }
        Thread.sleep(1000);
        service.shutdown();
        System.out.println(list.size());
    }
}
