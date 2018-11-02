package org.com.wink.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"test.xml"});
        Car car = (Car) context.getBean("car");
        car.inroduce();
    }
}
