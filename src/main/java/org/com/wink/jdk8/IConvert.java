package org.com.wink.jdk8;

@FunctionalInterface
public interface IConvert<F,T> {

    T conver(F form);
}
