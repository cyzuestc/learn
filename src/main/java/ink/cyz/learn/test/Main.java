package ink.cyz.learn.test;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @ Author      : Zink
 * @ Date        : Created in 18:12 2019/10/7
 * @ Description :
 * @ Version     : 1.0
 **/
public class Main {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        latch.countDown();
    }
}
