package org.com.wink.thread.StopThread;

public class InterruptDemo {

    private static class Task implements Runnable{
       /* @Override
        public void run() {
            *//*此例子当外界调用interrupt的时候，会报个错然后继续进行while的循环且一直进行下去。
            因为当抛出中断异常InterruptedException之后会立即将中断表示符清楚即设为false，while在外层故重新进入循环*//*
            while (!Thread.currentThread().isInterrupted()){
                System.out.println("start......");
                try {
                    System.out.println("startttttttt......");
                    Thread.sleep(10000l);
                } catch (InterruptedException e) {
                    System.out.println("有人把我中断了。。。。。");
                }
                System.out.println("enddddddd");
            }
        }*/

        @Override
        public void run() {
            /*因为while在try里面，所以在外界调用interrupt之后就算立即清除中断标识符也不会再次进入循环*/
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
        }
    }

    public static void main(String[] args){
        Thread thread = new Thread(new Task());
        thread.start();
        try {
            Thread.sleep(3000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
