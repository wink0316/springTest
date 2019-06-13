package org.com.wink.thread.CompareAndSwap.AQStool;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * latch.await()等待到latch.countDown()个数达到要求
 */
public class RunGameCountDownLatch {

    private static int groupSize = 5;
    private static Random random = new Random();

    public static void main(String[] args) {
        runGame("分组A");
        runGame("分组B");
    }

    private static void runGame(String groupName){
        CountDownLatch preLatch = new CountDownLatch(groupSize);
        CountDownLatch startRunLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(groupSize);

        System.out.println(groupName + "开始进行赛跑......");
        for (int i = 0; i < groupSize; i++) {
             new Thread(groupName + "->线程"+String.valueOf(i)+":"){
                 @Override
                 public void run() {
                     System.out.println(getName()+"准备完毕!!!!");
                     preLatch.countDown();
                     try {
                         startRunLatch.await();
                         System.out.println(getName()+"接受到枪声，开跑。。。。。");
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     try {
                         Thread.sleep(Math.abs(random.nextInt()) % 10000);
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                     endLatch.countDown();
                     System.out.println(getName()+"到达终点。。。");
                 }
             }.start();
        }

        try {
            System.out.println("等待所有人准备完毕");
            preLatch.await();
            System.out.println("所有人准备就绪，准备开枪。。。");
            startRunLatch.countDown();
            System.out.println("开始！！！！！！");
            endLatch.await();
            System.out.println("所有人结束。。。比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
