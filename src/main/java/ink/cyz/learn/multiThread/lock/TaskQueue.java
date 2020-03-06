package ink.cyz.learn.multiThread.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TaskQueue {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void add(String index){
        try {
        lock.lock();
        queue.add(index);
        condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String get() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()){
                condition.wait();
            }
            return queue.remove();
        } finally {
            lock.unlock();
        }
    }
}
