package com.sort;

import java.util.Arrays;

public class CountSort {
    public static int[] sort(int[] arr) {
        int max = arr[0];
        for(int i=0;i<arr.length;i++) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        int[] countArray = new int[max+1];
        for(int i=0; i<arr.length; i++) {
            countArray[arr[i]]++;
        }
        int index = 0;
        int[] sortedArray = new int[arr.length];
        for(int i=0; i<countArray.length; i++) {
            for (int j=0; j<countArray[i]; j++) {
                sortedArray[index++] = i;
            }
        }
        return sortedArray;
    }

    public static int[] sort1(int[] arr) {
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
        int d = max - min;

        int[] countArray = new int[d+1];

        for(int i=0; i<arr.length; i++) {
            countArray[arr[i]- min]++;
        }

        for(int i=1; i<countArray.length; i++) {
            countArray[i] += countArray[i-1];
        }

        int[] sortedArray = new int[arr.length];
        for (int i=sortedArray.length -1; i>=0; i--) {
            sortedArray[countArray[arr[i]-min]-1]=arr[i];
            countArray[arr[i] - min]--;
        }
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4,4,6,5,3,2,8,1,7,5,6,0,10};
        int[] sortedArray = sort(array);
        System.out.println(Arrays.toString(sortedArray));
        int[] arr = new int[] {95,94,91,98,99,90,99,93,91,92};
        int[] sortedArr = sort1(arr);
        System.out.println(Arrays.toString(sortedArr));
    }
}
