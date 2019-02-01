package org.com.wink.jdk8.lambda;

import javafx.collections.ListChangeListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntSupplier;

/**
 * // 1. 不需要参数,返回值为 5
 () -> 5

 // 2. 接收一个参数(数字类型),返回其2倍的值
 x -> 2 * x

 // 3. 接受2个参数(数字),并返回他们的差值
 (x, y) -> x – y

 // 4. 接收2个int型整数,返回他们的和
 (int x, int y) -> x + y

 // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
 (String s) -> System.out.print(s)
 */

public class test {

    private static List<String> players =  new ArrayList<>();

    static {
        String[] atp = {"A", "B","C","D","E","F","G","H"};
        players =  Arrays.asList(atp);
    }

    public static void main(String[] args) {
        //print();
        //threadModel();
        Comparator<String> stringComparator = (String s1, String s2) -> (s1.compareTo(s2));

    }


    public static void print(){
        for (String s : players) {
            System.out.println(s);
        }
        Consumer tConsumer = (player) -> System.out.println(player + ";");
        players.forEach((p) -> System.out.println(p + ";"));
        players.forEach(System.out::println);
    }

    public static void threadModel(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("olddddddddddddd");
            }
        }).start();

        new Thread(() -> System.out.println("newwwwwwwww")
        ).start();
    }

}
