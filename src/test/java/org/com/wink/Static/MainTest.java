package org.com.wink.Static;

public class MainTest {

    public static void main(String[] args) throws Exception{
        Class.forName("org.com.wink.Static.StaticTestA");
        StaticTestA a = new StaticTestA();
        StaticTestA b = new StaticTestA();
    }
}
