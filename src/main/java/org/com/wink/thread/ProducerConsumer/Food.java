package org.com.wink.thread.ProducerConsumer;

public class Food {

    private static int counter = 0;

    private int i;//当前生产的第i个菜

    public Food() {
        i = counter++;
    }

    @Override
    public String toString() {
        return "当前第"+ i +"个菜....";
    }
}
