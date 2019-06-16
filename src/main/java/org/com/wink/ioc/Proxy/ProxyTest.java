package org.com.wink.ioc.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
        try {
            IHello1 iHello1 = BeanFactory.getBean("org.com.wink.ioc.Proxy.HelloImpl", IHello1.class);
            iHello1.sayHelloWords("wink");
            System.out.println("===================");
            String info = iHello1.getInfo();
            System.out.println("info = " + info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
