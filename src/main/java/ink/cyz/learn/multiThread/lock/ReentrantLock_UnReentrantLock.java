package ink.cyz.learn.multiThread.lock;

import java.util.concurrent.atomic.AtomicBoolean;

public class ReentrantLock_UnReentrantLock {
    class Count{
        private int num = 0;
        private MyUnReentrantLock lock = new MyUnReentrantLock();
        public void add(){
            lock.lock();
            num++;
            lock.unlock();
            System.out.println(num);
        }
    }
    class MyUnReentrantLock {
        private AtomicBoolean isLocked = new AtomicBoolean(false);
        public synchronized void lock() {
            while (!isLocked.get()){
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            isLocked.compareAndSet(false,true);
        }

        public synchronized void unlock() {
            isLocked.compareAndSet(true,false);
            this.notifyAll();
        }
    }
    class MyReentrantLock {
        boolean isLocked = false;
        Thread lockedBy =  null;
        private int LockCount = 0;

        public synchronized void lock() throws InterruptedException {
            Thread thread = Thread.currentThread();
            while (isLocked && thread!=lockedBy){
                this.wait();
            }
            isLocked = true;
            LockCount++;
        }

        public synchronized void unlock() {
            if (Thread.currentThread()!=lockedBy||LockCount<0)return;
            LockCount--;
            if (LockCount==0){
                isLocked = false;
                this.notifyAll();
            }
        }
    }
}
