package org.com.wink.thread.CompareAndSwap;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Increment {

    private AtomicInteger atomic = new AtomicInteger();

    public void increat(){
        while (true){
            int current = atomic.get();
            if(atomic.compareAndSet(current, current + 1)){
                break;
            }else {
                System.out.println("失败啦!!!!!!");
            }
        }
        //atomic.incrementAndGet();
        //i++;
    }

    public Integer getI() {
        return atomic.get();
    }

    public static void main(String[] args) {
        Increment increment = new Increment();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increment.increat();
                }
            });
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            //thread.start();//???线程的启动放到这就没有问题???
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("最后结果：i = " + increment.getI());
    }
}
