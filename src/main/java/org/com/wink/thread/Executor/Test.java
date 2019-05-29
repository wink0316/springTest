package org.com.wink.thread.Executor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args) {
        //ExecutorService executor = Executors.newSingleThreadExecutor();
        ExecutorService executor = Executors.newFixedThreadPool(1);
        Future<Integer> future = executor.submit(new AddTask(1, 2));
        System.out.println("-------->");
        Integer result = null;
        try {
            System.out.println("开始等待结果");
            result = future.get();//执行future.get()时。在没有返回结果之前会一直阻塞在这
            System.out.println("结果返回");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("结果等于" + result);
        //executor.shutdown();//除非手动关闭，否则线程池一直在
    }
}
