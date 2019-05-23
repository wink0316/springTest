package org.com.wink.thread.CompareAndSwap.AQS;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class IncrementWithAQS {

    private int i = 0;
    private PlainLock lock = new PlainLock();
    private ReentrantLock rLock = new ReentrantLock();

    public void increase(){

        /*rLock.lock();
        i++;
        rLock.unlock();*/

        lock.lock();
        i++;
        lock.unlock();
    }

    public int getI() {
        return i;
    }

    public static void main(String[] args) {

        IncrementWithAQS increment = new IncrementWithAQS();
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(() ->{
                for (int j = 0; j < 10000; j++) {
                    increment.increase();
                }
            });
            t.start();
            threads.add(t);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(increment.getI());

    }
}
