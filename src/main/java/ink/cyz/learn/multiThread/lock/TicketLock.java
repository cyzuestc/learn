package ink.cyz.learn.multiThread.lock;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock {
    @Test
    public void t() throws InterruptedException {
        TicketLock t = new TicketLock();
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                t.lock();
            }).start();
        }
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                t.unLock();
            }).start();
        }
        Thread.sleep(1000);

    }

    private AtomicInteger come = new AtomicInteger();
    private AtomicInteger leave = new AtomicInteger();
    public int lock(){
        int currentTicketNum = come.incrementAndGet();
        while (currentTicketNum != leave.get()){
            //do something
        }
        System.out.println(currentTicketNum+"安排上了");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return currentTicketNum;
    }
    public void unLock(){
        leave.incrementAndGet();
    }



}
