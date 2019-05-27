package org.com.wink.thread.CompareAndSwap.AQStool;

import java.util.concurrent.CyclicBarrier;

/**
 * barrier.await();
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {

        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        CyclicBarrier barrierAction = new CyclicBarrier(5,() -> {
            System.out.println("达成之后优先执行。。。。。。。");
        });

        new Fighter(cyclicBarrier,"A",10000l).start();
        new Fighter(cyclicBarrier,"B",10000l).start();
        new Fighter(cyclicBarrier,"C",10000l).start();
        new Fighter(cyclicBarrier,"D",20000l).start();
        new Fighter(cyclicBarrier,"E",10000l).start();


    }
}
