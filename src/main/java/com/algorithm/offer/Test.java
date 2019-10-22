package com.algorithm.offer;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Test {
    public static void main(String[] args) throws Exception{
        /*long start = System.currentTimeMillis();
        long sum = 0L;
        for (long i = 0; i <= Integer.MAX_VALUE; i++) {
            sum += i;
        }
        System.out.println(sum);
        System.out.println(System.currentTimeMillis() - start);*/
        "Hello,World".chars().forEach(System.out :: print);
        while (true) {
            System.out.println(ThreadLocalRandom.current().nextInt());
        }
    }
}
