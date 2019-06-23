package com.algorithm;

/**
 * 一个无序数组,获得他的有序数组相邻的两个值的最大差值
 */
public class MaxSortedDistance {
    public static int getMaxSortedDistance(int[] arr) {
        int max = arr[0];
        int min = arr[0];

        for(int i=0; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        int d = max-min;
        if(d == 0) {
            return 0;
        }
        int bucketNum = arr.length;
        Bucket[] buckets = new Bucket[bucketNum];
        for (int i=0; i<bucketNum;i++) {
            buckets[i] = new Bucket();
        }
        //遍历原始数组
        for (int i=0;i<arr.length; i++) {
            //确定桶的下标
            int index = ((arr[i] - min) * (bucketNum-1) / d);
            if (buckets[index].min == null || buckets[index].min > arr[i]) {
                buckets[index].min = arr[i];
            }
            if(buckets[index].max == null || buckets[index].max < arr[i]) {
                buckets[index].max = arr[i];
            }
        }
        //遍历桶,找到最大差值
        int leftmax = buckets[0].max;
        int maxDistance = 0;
        for(int i=1; i<buckets.length; i++) {
            if(buckets[i].min == null) {
                continue;
            }
            if(buckets[i].min - leftmax > maxDistance) {
                maxDistance = buckets[i].min - leftmax;
            }
            leftmax = buckets[i].max;
        }
        return maxDistance;
    }

    private static class Bucket {
        Integer min;
        Integer max;
    }
    public static void main(String[] args) {
        int[] array = new int[] {2,6,3,4,5,10,9};
        System.out.println(getMaxSortedDistance(array));
    }
}
