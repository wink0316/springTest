package org.com.wink.thread.Executor;

import java.util.concurrent.Callable;

public class LongTimeTask implements Callable{

    private Integer num;

    public LongTimeTask(Integer num) {
        this.num = num;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "正在执行第" + num + "个任务.......");
        Thread.sleep(5000);
        return null;
    }
}
