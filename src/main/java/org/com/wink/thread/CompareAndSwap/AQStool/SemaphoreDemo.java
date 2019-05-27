package org.com.wink.thread.CompareAndSwap.AQStool;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(5);//同一时间最多5个执行
        for (int i = 0; i < 20; i++) {
            int num = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("当前第" + num +"个线程开始执行");
                    Thread.sleep(num * 1000);
                    System.out.println("当前第" + num +"个线程结束执行");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


}
