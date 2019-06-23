package com.leetcode.date611;

public class SolutionA {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            maxarea = Math.max(maxarea, Math.min(height[l],height[r])*(r-l));
            if(height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxarea;
    }

    public static void main(String[] args) {
        int result = new SolutionA().maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(result);
    }
}
