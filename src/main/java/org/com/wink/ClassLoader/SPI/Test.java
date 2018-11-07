package org.com.wink.ClassLoader.SPI;

import java.util.ServiceLoader;

public class Test {

    public static void main(String[] args) throws Exception{

        ServiceLoader<Dog> dogs = ServiceLoader.load(Dog.class);
        for (Dog dog : dogs) {
            dog.dosomething();
        }
    }
}
