package ink.cyz.learn.multiThread.lock;

import java.util.*;

public class FairLockDemo {
    class MyFairLock{
        private List<QueueObject> queue = new ArrayList();
        private boolean isLocked = false;
        private Thread lockingThread = null;

        public synchronized void lock(){
            QueueObject queueObject = new QueueObject();
            boolean isLockedForThisThread = true;
            synchronized (this){
                queue.add(queueObject);
            }
            while (isLockedForThisThread){
                synchronized (this){
                    isLockedForThisThread =
                            isLocked || queue.get(0) != queueObject;
                    if (!isLockedForThisThread){
                        isLocked = true;
                        queue.remove(queueObject);
                        lockingThread = Thread.currentThread();
                        return;
                    }
                }
            }
            try {
                queueObject.doWait();
            } catch (InterruptedException e) {
                synchronized (this){
                    Objects.requireNonNull(queueObject);
                }
                e.printStackTrace();
            }
        }
        public synchronized void unLock(){
            isLocked = false;
            lockingThread = null;
            if (queue.size()>0){
                queue.get(0).doNotify();
            }
        }

    }
    class QueueObject{
        private boolean isNotified = false;
        public synchronized void doWait() throws InterruptedException {
            while (!isNotified){
                this.wait();
            }
            isNotified = false;
        }
        public synchronized void doNotify(){
            this.isNotified = true;
            this.notify();
        }
    }
}
