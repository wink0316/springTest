package org.com.wink.ioc.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AopHandler implements InvocationHandler{

    private Object target;

    public AopHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用之前。。。。。。");
        Object result = method.invoke(target, args);
        System.out.println("调用之后。。。。。。result = " + result);
        return result;
    }
}
