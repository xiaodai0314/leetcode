package com;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class executor {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("current thread name: " + Thread.currentThread().getName());
                    try {
                        Object object = null;
                        System.out.println("result##" + object.toString());
                    } catch (Exception e) {
                        System.out.println("error");
                    }
                }
            });
        }
    }
}
