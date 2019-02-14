package org.com.wink.thread;

public class Test {

    public static void main(String[] args) {
        TestThread1 testThread = new TestThread1();
        Thread thread1 = new Thread(testThread);
        Thread thread2 = new Thread(testThread);

        thread1.setName("线程1");
        thread2.setName("线程2");

        thread1.start();
        thread2.start();
    }
}
