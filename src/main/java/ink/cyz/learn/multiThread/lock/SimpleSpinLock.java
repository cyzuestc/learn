package ink.cyz.learn.multiThread.lock;

import java.util.concurrent.atomic.AtomicBoolean;

public class SimpleSpinLock {
    private AtomicBoolean available = new AtomicBoolean();
    public void lock(){
        while (!tryLock()){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean tryLock(){
        return available.compareAndSet(false,true);
    }
    public void unLock(){
        if (!available.compareAndSet(true,false)){
            throw new RuntimeException("failed");
        }
    }
}
