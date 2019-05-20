package org.com.wink.thread.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public static void main(String[] args) {
        Queue<Food> queue = new LinkedList<>();
        new Cooker(queue,"c1").start();
        new Cooker(queue,"c2").start();
        new Cooker(queue,"c3").start();
        new Cooker(queue,"c4").start();
        new Cooker(queue,"c5").start();

        new Watier(queue,"w1").start();
        new Watier(queue,"w2").start();
        new Watier(queue,"w3").start();
        new Watier(queue,"w4").start();
        new Watier(queue,"w5").start();


    }
}
