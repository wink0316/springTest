package org.com.wink.thread.CompareAndSwap.AQStool;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Fighter extends Thread{

    private CyclicBarrier barrier;
    private Long times;

    public Fighter(CyclicBarrier barrier,String name,Long times) {
        super(name);
        this.barrier = barrier;
        this.times = times;
    }

    @Override
    public void run() {
        try {
            System.out.println(getName()+"---->begin wait");
            Thread.sleep(times);
            System.out.println(getName()+"---->end wait.wait all");
            barrier.await();
            System.out.println(getName()+"------------>end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e){
            e.printStackTrace();
        }
    }
}
