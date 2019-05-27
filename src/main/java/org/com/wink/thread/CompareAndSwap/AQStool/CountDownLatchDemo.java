package org.com.wink.thread.CompareAndSwap.AQStool;

import java.util.concurrent.CountDownLatch;

/**
 *  latch.countDown();
 *  latch.await();
 */
public class CountDownLatchDemo {

    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(5);

        for (int i = 0; i < 5; i++) {
            int num = i;
            new Thread(() -> {
                try {
                    System.out.println("线程开始:" + num);
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
                System.out.println("线程结束:" + num);
            }, "thread" + i).start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程等待结束");
    }
}
