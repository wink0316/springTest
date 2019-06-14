package org.com.wink;

import java.util.HashMap;
import java.util.Map;

/**
 * hashMap put的返回值。如果key不存在返回null。如果key存在，新value替换老value并返回老value
 */
public class Test {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        String s1 = map.put("A", "A1");
        System.out.println(s1);//null
        String s2 = map.put("B", "B1");
        System.out.println(s2);//null
        String s3 = map.put("A", "A2");
        System.out.println(s3);//A1
    }
}
