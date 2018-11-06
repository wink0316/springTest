package org.com.wink.ClassLoader;

import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        //testSystemProperties();
        //testClassLoader();
        try {
            MyClassLoaderTest();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSystemProperties(){
        Properties properties = System.getProperties();
        System.out.println(properties);
        System.out.println("=======================================");
        String property1 = System.getProperty("sun.boot.class.path");
        System.out.println(property1);
        String property2 = System.getProperty("java.ext.dirs");
        System.out.println(property2);
        String property3 = System.getProperty("java.class.path");
        System.out.println(property3);
    }

    public static void testClassLoader(){
        ClassLoader helloLoader = Hello.class.getClassLoader();
        System.out.println(helloLoader);
        ClassLoader intLoader = int.class.getClassLoader();
        System.out.println(intLoader);
        System.out.println(helloLoader.getParent());
        System.out.println(helloLoader.getParent().getParent());
    }

    public static void MyClassLoaderTest() throws Exception{

        MyDeskClassLoader myClassLoader = new MyDeskClassLoader("E:\\java");
        Class<?> aClass = myClassLoader.loadClass("org.com.wink.ClassLoader.Hello");
        if(aClass != null){
            Object obj = aClass.newInstance();
            Method sayHello = aClass.getDeclaredMethod("sayHello", null);
            sayHello.invoke(obj,null);
        }

    }
}