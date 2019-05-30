package org.com.wink.thread.StopThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {

    private static class Task implements Callable{
        @Override
        public Object call() throws Exception {
            try {
                while (!Thread.currentThread().isInterrupted()){
                    System.out.println("start......");
                    Thread.sleep(10000l);
                    System.out.println("startttttttt......");
                }
            } catch (InterruptedException e) {
                System.out.println("有人把我中断了。。。。。");
            }
            System.out.println("enddddddd");
            return null;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new Task());
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        future.cancel(true);//就算线程已经开始，也要中断
        //future.cancel(false);
    }
}
