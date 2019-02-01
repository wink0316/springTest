package org.com.wink.jdk8.stream;

import org.com.wink.jdk8.IConvert;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * https://blog.csdn.net/kegaofei/article/details/80582356
 * https://www.jianshu.com/p/9fe8632d0bc2
 * https://www.cnblogs.com/franson-2016/p/5593080.html
 * https://blog.csdn.net/qq_20989105/article/details/81234175
 */

public class test1 {

    private static List<String> characters =  new ArrayList<>();
    private static List<Player> players = new ArrayList<>();

    static {
        String[] character = {"x","y","z","A", "B","C","D","E","F","G","H"};
        characters =  Arrays.asList(character);

        players.add(new Player("lich",17));
        players.add(new Player("tiny",19));
        players.add(new Player("jugg",13));
        players.add(new Player("doom",24));
        players.add(new Player("puck",20));
        players.add(new Player("tiny2",19));
    }


    public static void main(String[] args) {

        //limit(4l);
        //sortByAgeOld();
        //sortByAgeLambda();
        //sortByAgeLambda2();
        //ageMoreThan(18);
        //getNames();
        //toSet();
        //toMapTest();
        toMapTest2();
    }


    private static void toMapTest2(){
        Map<String, Player> collect = players.stream().collect(Collectors.toMap(Player::getName, player -> player));
        System.out.println(collect);
        players.stream().collect(Collectors.toMap(Player::getName, player -> player.getAge()));
    }

    private static void toMapTest(){
        //key不能重复
        Map<Integer, String> collect = players.stream().collect(Collectors.toMap(Player::getAge, Player::getName));
        System.out.println(collect);
    }


    private static void toSet(){
        Set<String> collect = players.stream().map(Player::getName).collect(Collectors.toSet());
        System.out.println(collect);
    }

    private static void getNames(){
        List<String> names = players.stream().map(player -> player.getName()).collect(Collectors.toList());
        System.out.println(names);
        List<String> collect = players.stream().map(Player::getName).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void ageMoreThan(Integer age){
        List<Player> collect = players.stream().filter(player -> player.getAge() > age).collect(Collectors.toList());
        System.out.println(collect);
    }

    private static void sortByAgeLambda2(){
        Player[] playersArray = new Player[players.size()];
        //Function<Player, Integer> getAge = Player::getAge;
        Arrays.sort(players.toArray(playersArray),Comparator.comparing(Player::getAge));
        System.out.println(players);
        players = Arrays.asList(playersArray);
        System.out.println(players);
    }

    private static void sortByAgeLambda(){
        Player[] playersArray = new Player[players.size()];
        Arrays.sort(players.toArray(playersArray),(p1,p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println(players);
        players = Arrays.asList(playersArray);
        System.out.println(players);
    }


    private static void sortByAgeOld(){
        Player[] playersArray = new Player[players.size()];
        Arrays.sort(players.toArray(playersArray), new Comparator<Player>() {
            @Override
            public int compare(Player p1, Player p2) {
                return p1.getAge().compareTo(p2.getAge());
            }
        });
        System.out.println(players);
        players = Arrays.asList(playersArray);
        System.out.println(players);
    }

    private static void limit(Long limit){
        List<Player> collect = players.stream().limit(limit).collect(toList());
        System.out.println(collect);
    }
}
