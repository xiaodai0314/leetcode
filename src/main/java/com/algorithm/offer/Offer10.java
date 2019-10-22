package com.algorithm.offer;

import java.util.Arrays;

/**
 * 动态规划,递归的一种 但是可以缓存递归值 增加效率
 */
public class Offer10 {

    /**
     * 非递归斐波那契数列
     * 动态规划,递归回影响效率
     * @param n
     * @return
     */
    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        fib[0] = 0;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }
        return fib[n];
    }

    public int fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }
        int pre2 = 0;
        int pre1 = 1;
        int fib = 0;
        for (int i=2; i<n + 1; i++) {
            fib = pre1 + pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
    }
    public int fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }

    /**
     * 🐸跳楼梯问题 一次可以跳1-n个台阶
     * 动态规划解决
     * @param target
     * @return
     */
    public int jumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp, 1);
        for (int i = 1; i < target; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j];
            }
        }
        return dp[target - 1];
    }

    /**
     * 数学方法解决
     * f(n-1) = f(n-2) + f(n-3) + ... + f(0)
     * f(n) = f(n-1) + f(n-2) + ... + f(0)
     *得出
     * f(n) = f(n-1) * 2
     * 等比数列
     */
    public int jumpFloor(int target) {
        return (int) Math.pow(2, target - 1);
    }

    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        System.out.println(new Offer10().fibonacci(45));
        System.out.println("方法一:" + (System.currentTimeMillis() - time1));
        long time2 = System.currentTimeMillis();
        System.out.println(new Offer10().fibonacci1(45));
        System.out.println("方法二:" + (System.currentTimeMillis() - time2));
        long time3 = System.currentTimeMillis();
        System.out.println(new Offer10().fibonacci2(45));
        System.out.println("方法三:" + (System.currentTimeMillis() - time3));
    }
}
