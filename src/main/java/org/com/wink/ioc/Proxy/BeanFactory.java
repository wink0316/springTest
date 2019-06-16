package org.com.wink.ioc.Proxy;

import java.lang.reflect.Proxy;

/**
 * 主要就两点：
 *      1.有一个类实现InvocationHandler接口，实现其中的invoke方法，供生成代理对象时使用。
 *      2.生成代理对象：Proxy.newProxyInstance(ClassLoader loader,Class<?>[] interfaces,InvocationHandler h)
 *
 * 动态代理：动态代理通过将原始对象作为代理对象的一个属性存在，当外部发生方法调用时，会执行这个invoke()方法，然后由它代理执行相应对象的方法。
 *
 * 动态代理与字节码增强的区别在于：动态代理在生成动态字节码时，并不是通过实现类创建子类的方式，而是通过类所拥有的接口列表来完成。也就是说，
 * 构造出来的类和实际的实现类一点关系也没有，是完全独立的一个类，只有接口的方法名与原始对象的方法名相同。因此动态代理必须基于接口。
 *
 * Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),aopHandler);
 *      1.生成类（这一步实质也是字节码增强技术，通过传入的接口列表生成实现类）---> target.getClass().getInterfaces()
 *      2.实例化（实例化时需传入InvocationHandler的实例化对象，用以调用其中的invoke方法） ---> aopHandler
 *
 */
public class BeanFactory {

    public static Object getBean(String className) throws Exception{
        Object target = Class.forName(className).newInstance();
        AopHandler aopHandler = new AopHandler(target);
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),aopHandler);
    }

    public static<T> T getBean(String className,Class<T> tClass) throws Exception{
        return (T)getBean(className);
    }
}
