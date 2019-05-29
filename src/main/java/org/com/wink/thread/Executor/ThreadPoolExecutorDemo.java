package org.com.wink.thread.Executor;

import java.util.concurrent.*;

/**
 * ???????当超过corePoolSize的线程来的时候居然是先放队列，超过队列长度再扩容到maximumPoolSize，还不行就是饱和策略?????????
 * https://blog.csdn.net/xiaobao5214/article/details/88309552
 */

public class ThreadPoolExecutorDemo {

    public static void main(String[] args) {
        /*ExecutorService executorService = new ThreadPoolExecutor(1,10,
                0, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());*/


        /*ExecutorService executorService = new ThreadPoolExecutor(1,1,
                0, TimeUnit.SECONDS,new LinkedBlockingDeque(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());*/

        /*ExecutorService executorService = new ThreadPoolExecutor(1,1,
                0, TimeUnit.SECONDS,new LinkedBlockingDeque(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());*/

        ExecutorService executorService = new ThreadPoolExecutor(1,1,
                0, TimeUnit.SECONDS,new LinkedBlockingDeque(1),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());

        executorService.submit(new LongTimeTask(1));
        System.out.println(1);
        executorService.submit(new LongTimeTask(2));
        System.out.println(2);
        executorService.submit(new LongTimeTask(3));
        System.out.println(3);
    }
}
