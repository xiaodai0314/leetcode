package com.algorithm.offer;

/**
 * 动态规划 & 贪婪算法
 *
 * 割绳子问题
 */
public class Offer14 {
    /**
     * 贪婪算法
     * @param n
     * @return
     */
    public static int integerBreak(int n) {
        if(n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        //尽可能多地减去长度为3的绳子
        int timeOf3 = n/3;
        //当绳子最后剩下的长度为4的时候,不能再减去长度为3的绳子
        //此时更好的放啊是把绳子剪成长度为2的两段
        if (n - timeOf3 * 3 == 1) {
            timeOf3 --;
        }
        int timeOf2 = (n - timeOf3 * 3);
        return (int) (Math.pow(3, timeOf3)) * (int) (Math.pow(2,timeOf2));
    }

    /**
     * 动态规划
     * @param n
     * @return
     */
    public static int integerBreak1(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[j] * (i - j)));
            }
        }
        return dp[n];
    }
}
