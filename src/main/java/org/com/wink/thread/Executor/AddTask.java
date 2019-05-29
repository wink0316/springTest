package org.com.wink.thread.Executor;

import java.util.concurrent.Callable;

public class AddTask implements Callable{

    int i;
    int j;

    public AddTask(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(i + " + " + j + " = ?");
        Thread.sleep(10000l);
        int sum = i + j;
        System.out.println(i + " + " + j + " = " + sum);
        return sum;
    }
}
