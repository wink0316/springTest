package org.com.wink.thread.ProducerConsumer;

import java.util.Queue;

public class Watier extends Thread{

    private Queue<Food> queue;

    public Watier(Queue<Food> queue,String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            Food food;
            synchronized (queue){
                while (queue.size() < 1){
                    try {
                        System.out.println(getName() + "当前没菜端。休息。队列:" + queue.size());
                        queue.wait();
                        System.out.println(getName() + "被叫醒。");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                food = queue.remove();
                queue.notifyAll();
            }
            System.out.println(getName() + "上菜中。" + food.toString());
            SleepUtil.randomSleep();
        }
    }
}
