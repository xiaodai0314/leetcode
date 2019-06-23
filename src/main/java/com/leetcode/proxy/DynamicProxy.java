package com.leetcode.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;
    private long starttime = 0;
    private long endtime = 0;
    public DynamicProxy(Object target) {
        this.target =target;
    }
    public <T> T getProxy() {
        return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        befor();
        Object result = method.invoke(target, args);
        after();
        return result;
    }
    private void befor() {
        starttime = System.currentTimeMillis();
        System.out.println(starttime);
    }
    private void after() {
        endtime = System.currentTimeMillis();
        System.out.println(endtime);
        System.out.println("消耗时间: " + (endtime - starttime));
    }
}
