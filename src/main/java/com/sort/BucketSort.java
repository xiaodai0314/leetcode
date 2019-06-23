package com.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class BucketSort {
    public static double[] sort(double[] arr) {
        double max = arr[0];
        double min = arr[0];
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
            if(arr[i] < min) {
                min = arr[i];
            }
        }
        double d = max - min;

        int bucketNum = arr.length;
        ArrayList<LinkedList<Double>> bucketList = new ArrayList<>();
        for (int i=0; i<bucketNum; i++) {
            bucketList.add(new LinkedList<Double>());
        }

        //遍历数组,将每个元素插入桶中
        for(int i=0; i<bucketList.size(); i++) {
            int num = (int)((arr[i] - min) * (bucketNum - 1)/d);
            bucketList.get(num).add(arr[i]);
        }

        //内部排序
        for(int i=0; i<bucketList.size(); i++) {
            Collections.sort(bucketList.get(i));
        }

        //输出
        double[] sortedArray = new double[arr.length];
        int index = 0;
        for(LinkedList<Double> list : bucketList) {
            for(double element : list) {
                sortedArray[index] = element;
                index++;
            }
        }
        return sortedArray;
    }

    public static void main(String[] args ) {
        double[] arr = new double[] {4.21,6.421,0.0023,3.0,2.123,8.122,4.12,10.09};
        double[] shortdeArray = sort(arr);
        System.out.println(Arrays.toString(shortdeArray));
    }
}
