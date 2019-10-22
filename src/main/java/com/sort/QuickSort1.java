package com.sort;

import java.util.Arrays;

public class QuickSort1 {
    public static void sort(int[] arrays, int startIndex, int endIndex) {
        if (startIndex>=endIndex) {
            return;
        }
        int mid = partition(arrays, startIndex, endIndex);
        sort(arrays, startIndex, mid - 1);
        sort(arrays, mid + 1, endIndex);
    }

    private static int partition(int[] arrays, int startInedx, int endIndex) {
        int left = startInedx;
        int right = endIndex;
        int mid = arrays[startInedx];
        while (left != right) {
            while (left < right && arrays[right] > mid) {
                right--;
            }
            while (left < right && mid >= arrays[left]) {
                left++;
            }
            if (left < right) {
                swep(arrays, left, right);
            }
        }
        arrays[startInedx] = arrays[left];
        arrays[left] = mid;
        return left;
    }

    public static void main(String[] args) throws Exception{
        int[] ints = new int[]{3,4,5,2,1,3,5,6,7,8,9,7,8,5,8,9,6,2};
        sort(ints, 0, ints.length-1);
        long start = System.nanoTime();
        System.out.println(String.valueOf(start));
        System.out.println(Arrays.toString(ints));
        long end = System.nanoTime();
        System.out.println(String.valueOf(end));
        System.out.println("用时: " + String.valueOf(end - start));
    }
    private static void swep(int[] ints,int i1, int i2){
        int temp = 0;
        temp = ints[i1];
        ints[i1] = ints[i2];
        ints[i2] = temp;
    }
}
