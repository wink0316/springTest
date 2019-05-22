package org.com.wink.thread;

import java.util.ArrayList;
import java.util.List;

public class Increment {

    private Integer i = 0;

    public synchronized void increat(){
        i++;
    }

    public Integer getI() {
        return i;
    }

    public static void main(String[] args) {
        Increment increment = new Increment();

        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
                Thread thread = new Thread(() -> {
                    for (int j = 0; j < 10000; j++) {
                        increment.increat();
                    }
                },"thread"+i);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            thread.start();//???线程的启动放到这就没有问题???
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("最后结果：i = " + increment.getI());
    }

}
