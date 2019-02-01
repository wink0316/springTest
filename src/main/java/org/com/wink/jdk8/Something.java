package org.com.wink.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Something {

    public Something() {
    }

    Something(String some){
        System.out.println(">>>>>>>>" + some + "<<<<<<<<<<<");
    }

    static String startWith(String some){
        return String.valueOf(some.charAt(0));
    }

    String dosomething(String some){
        return some;
    }

    String dosomething(String some1,String some2){
        return some1 + some2;
    }


    public static void main(String[] args) {
        IConvert<String, String> startWith = Something::startWith;
        System.out.println(startWith.conver("BCA"));

        Something something = new Something();
        IConvert<String, String> dosomething = something::dosomething;
        System.out.println(dosomething.conver("asd"));

    }
}
