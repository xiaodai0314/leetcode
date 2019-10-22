package com.algorithm.offer;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 旋转数组的最小数字
 */
public class Offer11 {
    //无重复的算法
    public static int minNumberInRotateArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l<h) {
            int m = l + (h-l)/2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return nums[l];
    }

    //有重复的方法
    public static int minNumberInRotateArray1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int l = 0;
        int h = nums.length - 1;
        while (l<h) {
            //中间数
            int m = l + (h-l)/2;
            if (nums[l] == nums[m] && nums[m] == nums[h]) {
                return minNumber(nums, l, h);
            } else if (nums[m] < nums[h]) {
                h = m;
            } else {
                l = m+1;
            }
        }
        return nums[l];
    }

    //
    private static int minNumber(int[] nums, int l, int h) {
        for (int i = l; i < h; i++) {
            if (nums[i] > nums[i + 1]) {
                return nums[i + 1];
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,0,1};
        System.out.println(Arrays.toString(nums));
        System.out.println(minNumberInRotateArray1(nums));
        System.out.println(Arrays.toString(nums));
    }
}

