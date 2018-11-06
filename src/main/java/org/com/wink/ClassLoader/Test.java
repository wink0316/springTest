package org.com.wink.ClassLoader;

import java.lang.reflect.Method;
import java.util.Properties;

public class Test {
    public static void main(String[] args) {
        //testSystemProperties();

        //testClassLoader();

        /*try {
            MyClassLoaderTest();
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        try {
            contextClassLoaderTest();
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
        ClassLoader helloLoader = HelloA.class.getClassLoader();
        System.out.println(helloLoader);
        ClassLoader intLoader = int.class.getClassLoader();
        System.out.println(intLoader);
        System.out.println(helloLoader.getParent());
        System.out.println(helloLoader.getParent().getParent());
    }

    public static void MyClassLoaderTest() throws Exception{

        MyDeskClassLoader myClassLoader = new MyDeskClassLoader("E:\\java");
        Class<?> aClass = myClassLoader.loadClass("org.com.wink.ClassLoader.HelloA");
        if(aClass != null){
            Object obj = aClass.newInstance();
            Method sayHello = aClass.getDeclaredMethod("sayHello", null);
            sayHello.invoke(obj,null);
        }
    }

    public static void contextClassLoaderTest() throws Exception{

        MyDeskClassLoader classLoader = new MyDeskClassLoader("E:\\java");
        Class<?> clazz1 = classLoader.loadClass("org.com.wink.ClassLoader.Hello");
        if(clazz1 != null){
            System.out.println(clazz1.getClassLoader().toString());
            Object obj1 = clazz1.newInstance();
            Method sayHello = clazz1.getDeclaredMethod("sayHello", null);
            sayHello.invoke(obj1,null);
        }

        MyDeskClassLoaderB classLoaderB = new MyDeskClassLoaderB("E:\\java\\hello");
        System.out.println("Thread:"+Thread.currentThread().getName()+" ,classLoader:"+Thread.currentThread().getContextClassLoader().toString());
        new Thread(new Runnable() {
            public void run() {
                System.out.println("Thread:"+Thread.currentThread().getName()+" ,classLoader:"+Thread.currentThread().getContextClassLoader().toString());
                try {
                    ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
                    Class<?> aClass = contextClassLoader.loadClass("org.com.wink.ClassLoader.Hello");
                    System.out.println(aClass.getClassLoader().toString());
                    if(aClass != null){
                        Object threadObj = aClass.newInstance();
                        Method threadSayHello = aClass.getDeclaredMethod("sayHello", null);
                        threadSayHello.invoke(threadObj,null);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
