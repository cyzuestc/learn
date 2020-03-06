package ink.cyz.learn.multiThread.lock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDemo {
    private final StampedLock stampedLock = new StampedLock();
    private double x;
    private double y;

    long stamp = stampedLock.writeLock();

}
