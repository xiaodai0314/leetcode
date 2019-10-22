package com.algorithm.offer;

public class Offer15 {

    //n & n-1 的结果就是把n的二进制最后一个1变成0
    public static int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1);
        }
        return count;
    }

    public static int otherNumberOf1 (int n) {
        return Integer.bitCount(n);
    }

    public static void main(String[] args) {
        System.out.println(numberOf1(10));
    }
}
