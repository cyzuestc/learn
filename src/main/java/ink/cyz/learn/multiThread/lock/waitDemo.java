package ink.cyz.learn.multiThread.lock;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

public class waitDemo {
    @Test
    public void t() throws InterruptedException {
        TaskQueue queue = new TaskQueue();
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                queue.get();
            }).start();
            new Thread(()->{
                queue.add("abc");
            }).start();
        }
        Thread.sleep(1000);
    }

    class TaskQueue{
        Queue<String> queue = new LinkedList<>();
        public synchronized void add(String s){
            this.queue.add(s);
            this.notifyAll();
        }
        public synchronized String get(){
            while (queue.isEmpty()){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("wait over");
            return queue.remove();
        }
    }
}
