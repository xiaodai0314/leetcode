package com.sort;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int start, int end) {
        if(start >= end) {
            return;
        }
        int pivot = partiton1(array, start, end);

        quickSort(array, start, pivot -1);
        quickSort(array, pivot + 1, end);
    }

    /**
     * 分治 ,双边循环法
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int partiton(int[] arr, int start, int end) {
        int pivot = arr[start];
        int left = start;
        int right = end;

        while (left != right) {
            while (left < right && arr[right] > pivot) {
                right--;
            }
            while (left <right && arr[left] <= pivot) {
                left++;
            }
            if (left < right) {
                int p = arr[left];
                arr[left] = arr[right];
                arr[right] = p;
            }
        }
        arr[start] = arr[left];
        arr[left] = pivot;

        return left;
    }

    /**
     * 分治 单边循环
     * @param arr
     * @param start
     * @param end
     * @return
     */
    private static int partiton1(int[] arr, int start, int end) {
        int pivot = arr[start];
        int mark = start;

        for (int i = start ; i<= end ;i++) {
            if(arr[i] < pivot) {
                mark ++;
                int p = arr[mark];
                arr[mark] = arr[i];
                arr[i] = p;
            }
        }

        arr[start] = arr[mark];
        arr[mark] = pivot;
        return mark;
    }

    public static  void main(String[] args) {
        int[] arr = new int[]{4,4,6,4,4,4,5,3,2,8,1};
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
