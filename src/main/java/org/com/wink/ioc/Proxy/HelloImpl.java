package org.com.wink.ioc.Proxy;

public class HelloImpl implements IHello1,IHello2{

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

    @Override
    public void sayHelloWords(String words) {
        System.out.println("hello ->" + words);
    }

    @Override
    public String getInfo() {
        return "winkkkkk";
    }

    @Override
    public String getInfo(String param) {
        return null;
    }

    @Override
    public void disPlay() {

    }

    @Override
    public String getParam() {
        return null;
    }
}
