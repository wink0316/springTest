package org.com.wink.thread.ProducerConsumer;

import java.util.Random;

public class SleepUtil {

    private static Random random = new Random();

    public static void randomSleep() {
        try {
            int i = random.nextInt(10);
            Thread.sleep(i * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
