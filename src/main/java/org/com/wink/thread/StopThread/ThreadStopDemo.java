package org.com.wink.thread.StopThread;

public class ThreadStopDemo {

    private static class Task implements Runnable{
        @Override
        public void run() {
            int a = 0;
            while (true){
                /*try {
                    Thread.sleep(10000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                if(a % 10000 == 0){
                    System.out.println(a);
                }
                a++;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread thread = new Thread(new Task());
        thread.start();
        Thread.sleep(3000l);
        thread.stop();

    }


}
