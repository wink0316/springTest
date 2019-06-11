package org.com.wink.thread;

public class ReadThreadTest extends Thread{

    private boolean ready;//volatile

    private int num;

    @Override
    public void run() {
        while (!ready){
            num++;
            //System.out.println(num);加上输出语句，可能会使线程到主存中去读取最新的值，从而退出
        }
        System.out.println("thread end ." + ready);
    }

    public void readyOn(){
        this.ready = true;
    }

    public static void main(String[] args) throws Exception{
        ReadThreadTest readThread = new ReadThreadTest();
        readThread.start();
        Thread.sleep(200);
        readThread.readyOn();
        System.out.println("main end." + readThread.ready);
    }
}
