package com.leetcode.proxy;

import com.leetcode.third.SolutionC;

public class Client {
    public static void main(String[] args) {
        Greeting greeting = new DynamicProxy(new SolutionC()).getProxy();
        greeting.sayHello("14615");
    }
}
