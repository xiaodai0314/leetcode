package com.algorithm.offer;

/**
 * 调整数组顺序是奇数位于偶数前面
 */
public class Offer21 {
    public static void reOrderArray(int[] nums) {
        int oddCnt = 0;
        for (int x : nums) {
            if (!isEven(x)) {
                oddCnt++;
            }
        }
        int[] copy = nums.clone();
        int i = 0;
        int j = oddCnt;
        for (int num : copy) {
            if (num % 2 == 1) {
                nums[i++] = num;
            } else {
                nums[j++] = num;
            }
        }
    }
    private static boolean isEven(int x) {
        return x % 2 == 0;
    }
}
