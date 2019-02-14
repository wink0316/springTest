package org.com.wink.thread;

public class TestThread1 implements Runnable{
    int i = 1;
    @Override
    public void run() {
        while (true){
            synchronized (this){
                notify();
                /*try {
                    //Thread.currentThread();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                if (i < 100){
                    //notify();
                    String name = Thread.currentThread().getName();
                    System.out.println(name + ":" + i);
                    i++;
                    try {
                        System.out.println(name + "开始等待。。。。");
                        wait();
                        System.out.println(name + "等待结束。。。。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
