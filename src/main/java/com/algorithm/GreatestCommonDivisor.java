package com.algorithm;

/**
 * 求最大公约数
 */
public class GreatestCommonDivisor {
    /**
     * 枚举法
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor(int a, int b) {
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if(big%small == 0) {
            return small;
        }
        for(int i=small/2; i>1; i--) {
            if(small%i==0 && big%i==0) {
                return i;
            }
        }
        return 1;
    }

    /**
     * 欧几里得算法,辗转相除法
     * 两个数的最大公约数等于最小的数与两个数的余数的最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor1(int a, int b) {
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        if(big%small == 0) {
            return small;
        }
        return getGreatestCommonDivisor1(big%small,small);
    }

    /**
     * 耿相减损术
     * 两个正整数他们的最大公约数等于他们的差值与较小值的最大公约数
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor2(int a, int b) {
        if(a==b) {
            return a;
        }
        int big = a>b ? a:b;
        int small = a<b ? a:b;
        return getGreatestCommonDivisor2(big-small, small);
    }

    /**
     * 移位运算法
     * @param a
     * @param b
     * @return
     */
    public static int getGreatestCommonDivisor3(int a, int b) {
        if(a==b) {
            return a;
        }
        if((a&1)==0 && (b&1)==0) {
            return getGreatestCommonDivisor3(a>>1, b>>1);
        } else if((a&1)==0 && (b&1)!=0) {
            return getGreatestCommonDivisor3(a>>1, b);
        } else if((a&1)!=0 && (b&1)==0) {
            return getGreatestCommonDivisor3(a, b>>1);
        } else {
            int big = a>b ? a:b;
            int small = a<b ? a:b;
            return getGreatestCommonDivisor3(big-small, small);
        } 
    }
}
