package org.com.wink.thread.ProducerConsumer;

import java.util.Queue;

public class Cooker extends Thread{

    private Queue<Food> queue;

    public Cooker(Queue<Food> queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true){
            System.out.println(getName() + "开始做菜.....");
            SleepUtil.randomSleep();
            Food food = new Food();
            System.out.println(getName() + "菜做好。" + food.toString());

            synchronized (queue){
                while (queue.size() > 4){
                    System.out.println("当前至少5个菜，停止加菜。休息ing。。。。。" + getName() + ">" + food.toString());
                    try {
                        queue.wait();
                        System.out.println("提示没菜，尝试开始放菜。当前菜：" + getName() + ">" + food.toString());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.add(food);
                queue.notifyAll();
            }
        }
    }
}
