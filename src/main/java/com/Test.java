package com;

import com.thread.Singleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        System.out.println(singleton);
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
    }
}
