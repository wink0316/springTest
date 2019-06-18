package org.com.wink.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

public class Test1 {
    public static void main(String[] args) throws Exception{
        /*ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"test.xml"});
        Car car = (Car) context.getBean("car");
        car.inroduce();*/

        /*URL resource = Test1.class.getClassLoader().getResource("test.xml");
        System.out.println(resource.getFile());

        InputStream inputStream = Test1.class.getClassLoader().getResourceAsStream("test.xml");
        System.out.println(inputStream);*/

        Enumeration<URL> resources = Test1.class.getClassLoader().getResources("classes/test.xml");
        while (resources.hasMoreElements()){

            System.out.println("xxxxxxx");
            URL url = resources.nextElement();
            //System.out.println(url.toURI());
            System.out.println(url.getFile());
        }

    }
}
