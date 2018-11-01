package org.com.wink.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {

    public static Car initByReflect()throws Exception{

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class<?> clazz = classLoader.loadClass("org.com.wink.ioc.Car");

        Constructor<?> constructor = clazz.getDeclaredConstructor(null);
        Car car = (Car)constructor.newInstance();

        Method setBrand = clazz.getMethod("setBrand", String.class);
        setBrand.invoke(car,"oooo");
        Method setColor = clazz.getMethod("setColor", String.class);
        setColor.invoke(car,"white");
        Method setMaxSpeed = clazz.getMethod("setMaxSpeed", int.class);
        setMaxSpeed.invoke(car,12);

        return car;
    };

    public static void main(String[] args) throws Exception{
        Car c = initByReflect();
        c.inroduce();
    }
}
